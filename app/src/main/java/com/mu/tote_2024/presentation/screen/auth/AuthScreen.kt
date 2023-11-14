package com.mu.tote_2024.presentation.screen.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mu.tote_2024.R
import com.mu.tote_2024.presentation.components.LogonButton
import com.mu.tote_2024.presentation.theme.ColorBackgroundLight
import com.mu.tote_2024.utils.Routes

@Composable
fun LogonScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = ColorBackgroundLight
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogonButton(
                R.string.sign_up,
                onClick = {
                    Log.d("tote2024", "SignUp")
                    navController.navigate(Routes.SIGN_UP_SCREEN) {
                        popUpTo(Routes.SPLASH_SCREEN) {
                            inclusive = true
                        }
                    }

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                modifier = Modifier.size(248.dp),
                painter = painterResource(id = R.drawable.mascot),
                contentDescription = "mascot"
            )
            Spacer(modifier = Modifier.height(16.dp))
            LogonButton(
                R.string.sign_in,
                onClick = {
                    Log.d("tote2024", "SignIn")
                }
            )
        }
    }
}