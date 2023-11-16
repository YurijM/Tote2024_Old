package com.mu.tote_2024.presentation.screen.auth

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mu.tote_2024.R
import com.mu.tote_2024.presentation.components.AuthTextField
import com.mu.tote_2024.presentation.theme.ColorApplication
import com.mu.tote_2024.presentation.theme.ColorBackground
import com.mu.tote_2024.presentation.theme.ColorBackgroundLight
import com.mu.tote_2024.presentation.theme.ColorDisabledBackground
import com.mu.tote_2024.presentation.theme.ColorDisabledText
import com.mu.tote_2024.utils.Constants.DEBUG_TAG
import com.mu.tote_2024.utils.Constants.Routes
import com.mu.tote_2024.utils.Constants.MIN_PASSWORD_LENGTH

/*@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}*/

@SuppressLint("UnrememberedMutableState")
@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val email = mutableStateOf<String?>(null)
    val password = mutableStateOf<String?>(null)
    val passwordConfirm = mutableStateOf<String?>(null)

    val isLoading = mutableStateOf(false)

    val state by viewModel.state.collectAsState()
    Log.d(DEBUG_TAG, "$state")

    LaunchedEffect(key1 = true) {
        if (email.value != null && email.value!!.isNotBlank()
            && password.value != null && password.value!!.isNotBlank()
        ) {
            when {
                state.isLoading -> {
                    isLoading.value = true
                }

                state.isSuccess -> {
                    //isLoading.value = false

                    viewModel.sendEvent(AuthEvent.Default)

                    navController.navigate(Routes.MAIN_SCREEN) {
                        popUpTo(Routes.LOGON_SCREEN) {
                            inclusive = true
                        }
                    }
                }

                (state.error != null) -> {
                    //isLoading.value = false
                }

                else -> {}
            }
        }
    }

    /*when {
        state.isLoading -> {
            isLoading.value = true
        }

        state.isSuccess -> {
            isLoading.value = false

            viewModel.sendEvent(AuthEvent.Default)

            navController.navigate(Routes.MAIN_SCREEN) {
                popUpTo(Routes.LOGON_SCREEN) {
                    inclusive = true
                }
            }
        }

        (state.error != null) -> {
            isLoading.value = false
        }

        else -> {*/

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = ColorBackgroundLight,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.sign_up),
                color = ColorApplication,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(
                    width = 2.dp,
                    color = ColorApplication
                ),
                colors = CardDefaults.cardColors(
                    containerColor = ColorBackgroundLight
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp,
                            start = 12.dp,
                            end = 12.dp,
                            bottom = 16.dp,
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AuthTextField(
                        value = email.value,
                        onChange = { newValue ->
                            email.value = newValue
                        },
                        label = stringResource(id = R.string.enter_email),
                        painterId = R.drawable.ic_mail,
                        description = "email",
                        errorMessage = stringResource(R.string.error_field_empty)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    AuthTextField(
                        label = stringResource(id = R.string.enter_password),
                        value = password.value,
                        onChange = { newValue ->
                            password.value = newValue
                        },
                        painterId = R.drawable.ic_password,
                        description = "password",
                        errorMessage = stringResource(R.string.error_min_length, MIN_PASSWORD_LENGTH)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    AuthTextField(
                        label = stringResource(id = R.string.confirm_password),
                        value = passwordConfirm.value,
                        onChange = { newValue ->
                            passwordConfirm.value = newValue
                        },
                        painterId = R.drawable.ic_password,
                        description = "passwordConfirm",
                        errorMessage = stringResource(R.string.error_min_length, MIN_PASSWORD_LENGTH)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ColorBackground,
                            contentColor = ColorApplication,
                            disabledContainerColor = ColorDisabledBackground,
                            disabledContentColor = ColorDisabledText,
                        ),
                        //enabled = false,
                        onClick = {
                            viewModel.sendEvent(
                                AuthEvent.OnSignUp(
                                    email = email.value ?: "",
                                    password = password.value ?: ""
                                )
                            )
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.to_register)
                        )
                    }
                }
            }
        }
        if (isLoading.value) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(150.dp)
                    .padding(50.dp),
                color = ColorApplication,
                strokeWidth = 3.dp
            )
        }
    }
}

