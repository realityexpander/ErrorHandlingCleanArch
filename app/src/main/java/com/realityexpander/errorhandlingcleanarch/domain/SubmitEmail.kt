package com.realityexpander.errorhandlingcleanarch.domain

import com.realityexpander.errorhandlingcleanarch.R
import com.realityexpander.errorhandlingcleanarch.data.MyRepositoryImpl
import com.realityexpander.errorhandlingcleanarch.common.Resource
import com.realityexpander.errorhandlingcleanarch.common.UiText

class SubmitEmail(
    private val repository: MyRepository = MyRepositoryImpl()
) {
    suspend fun execute(email: String): Resource<Unit> {
        if(!email.contains("@")) {
            return Resource.Error(
                UiText.StringResource(R.string.error_invalid_email)
            )
        }
        return repository.submitEmail(email)
    }
}