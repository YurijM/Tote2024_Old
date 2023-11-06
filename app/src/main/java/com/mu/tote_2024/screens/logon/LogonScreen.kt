package com.mu.tote_2024.screens.logon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.tote_2024.R
import com.mu.tote_2024.ui.theme.ColorApplication
import com.mu.tote_2024.ui.theme.ColorBackgroundLight

@Preview(showBackground = true)
@Composable
fun LogonScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = ColorBackgroundLight
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = stringResource(R.string.sign_in),
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                modifier = Modifier.size(248.dp),
                painter = painterResource(id = R.drawable.mascot),
                contentDescription = "mascot"
            )
            Spacer(modifier = Modifier.height(16.dp))
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
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = stringResource(R.string.login),
                    fontSize = 20.sp
                )
            }
        }
    }
}