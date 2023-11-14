package com.mu.tote_2024.presentation.screen.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.tote_2024.R
import com.mu.tote_2024.presentation.components.AuthTextField
import com.mu.tote_2024.presentation.theme.ColorApplication
import com.mu.tote_2024.presentation.theme.ColorBackgroundLight

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun SignUpScreen() {
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val passwordConfirm = mutableStateOf("")

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
                    containerColor = Color.Transparent
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp,
                            start = 12.dp,
                            end = 12.dp,
                            bottom = 16.dp,
                            )
                ) {
                    AuthTextField(
                        value = email.value,
                        onChange = { newValue ->
                            email.value = newValue
                        },
                        label = "Укажите свой email",
                        imageVector = Icons.Default.Email,
                        description = "email",
                        errorMessage = "Поле не может быть пустым"
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    AuthTextField(
                        label = "Введите пароль",
                        value = password.value,
                        onChange = { newValue ->
                            password.value = newValue
                        },
                        imageVector = Icons.Default.Password,
                        description = "password",
                        errorMessage = "Поле должно содержать не меньше 6 символов"
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    AuthTextField(
                        label = "Подтвердите пароль",
                        value = passwordConfirm.value,
                        onChange = { newValue ->
                            passwordConfirm.value = newValue
                        },
                        imageVector = Icons.Default.Password,
                        description = "passwordConfirm",
                        errorMessage = "Поле должно содержать не меньше 6 символов"
                    )
                }
            }
        }

    }
}