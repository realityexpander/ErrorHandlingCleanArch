package com.realityexpander.errorhandlingcleanarch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.realityexpander.errorhandlingcleanarch.presentation.MainViewModel
import com.realityexpander.errorhandlingcleanarch.ui.theme.ErrorHandlingCleanArchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ErrorHandlingCleanArchTheme {
                val viewModel = viewModel<MainViewModel>()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Email field
                    TextField(
                        value = viewModel.email,
                        onValueChange = viewModel::onEmailChange,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = MaterialTheme.typography.body1,
                        label = { Text("Email", color = Color.LightGray) },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = MaterialTheme.colors.onBackground,
                            backgroundColor = MaterialTheme.colors.background,
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Submit button
                    Button(
                        onClick = viewModel::submit,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Submit")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // Show error message if there is any
                    viewModel.message?.let {
                        Text(text = it.asString())
                    }
                }
            }
        }
    }
}