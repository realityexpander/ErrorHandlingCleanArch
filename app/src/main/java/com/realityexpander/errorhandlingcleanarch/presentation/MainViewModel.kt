package com.realityexpander.errorhandlingcleanarch.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.realityexpander.errorhandlingcleanarch.R
import com.realityexpander.errorhandlingcleanarch.domain.SubmitEmail
import com.realityexpander.errorhandlingcleanarch.common.Resource
import com.realityexpander.errorhandlingcleanarch.common.UiText
import kotlinx.coroutines.launch

class MainViewModel(
    private val submitEmail: SubmitEmail = SubmitEmail()
): ViewModel() {

    var email by mutableStateOf("")
        private set

    var message by mutableStateOf<UiText?>(null)

    fun onEmailChange(email: String) {
        this.email = email
    }

    fun submit() {
        viewModelScope.launch {
            val result = submitEmail.execute(email)
            message = when(result) {
                is Resource.Success -> {
                    UiText.StringResource(R.string.successfully_submitted)
                }
                is Resource.Error -> {
                    result.message
                }
            }
        }
    }
}