package com.mu.tote_2024.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.tote_2024.R

@Composable
fun AuthTextField(
    label: String,
    value: String,
    onChange: (newValue: String) -> Unit,
    imageVector: ImageVector,
    description: String,
    errorMessage: String
) {
    val showPassword = remember {
        mutableStateOf(false)
    }
    val hasError = remember {
        mutableStateOf(false)
    }

    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { newValue ->
                onChange(newValue)
            },
            label = {
                Text(text = label)
            },
            leadingIcon = {
                Icon(
                    imageVector = imageVector,
                    contentDescription = description
                )
            },
            singleLine = true,
            visualTransformation = if (
                label.contains("парол", true)
                && !showPassword.value
            ) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                if (label.contains("парол", true)) {
                    Icon(
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                showPassword.value = !showPassword.value
                            },
                        painter = if (showPassword.value) {
                            painterResource(id = R.drawable.ic_hide)
                        } else {
                            painterResource(id = R.drawable.ic_show)
                        },
                        contentDescription = "eye"
                    )
                }
            },
            isError = if (
                value.isBlank()
                || (label.contains("парол", true) && value.length <= 6)
            ) {
                hasError.value = true
                true
            } else {
                hasError.value = false
                false
            }
        )
        if (hasError.value) {
            Text(
                modifier = Modifier.padding(
                    top = 4.dp,
                    start = 4.dp,
                    end = 4.dp,
                    bottom = 0.dp
                ),
                text = errorMessage,
                color = Color.Red,
                fontSize = 12.sp
            )
        }
    }
}
