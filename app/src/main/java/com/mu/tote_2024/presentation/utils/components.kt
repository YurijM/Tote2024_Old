package com.mu.tote_2024.presentation.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.tote_2024.presentation.theme.ColorApplication

@Composable
fun LogonButton(
    titleId: Int,
    onClick: () -> Unit
) {
    OutlinedButton(
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = ColorApplication
        ),
        border = BorderStroke(
            width = 2.dp,
            color = ColorApplication
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 12.dp
        ),
        onClick = { onClick() }
    ) {
        Text(
            text = stringResource(titleId),
            fontSize = 20.sp
        )
    }
}