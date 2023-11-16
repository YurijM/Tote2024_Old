package com.mu.tote_2024.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mu.tote_2024.presentation.screen.auth.AuthScreen
import com.mu.tote_2024.presentation.screen.auth.SignUpScreen
import com.mu.tote_2024.presentation.screen.main_screen.MainScreen
import com.mu.tote_2024.presentation.screen.splash_screen.SplashScreen
import com.mu.tote_2024.utils.Constants.Routes

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH_SCREEN
    ) {
        composable(Routes.SPLASH_SCREEN) {
            SplashScreen(navController = navController)
        }
        composable(Routes.LOGON_SCREEN) {
            AuthScreen(navController = navController)
        }
        composable(Routes.SIGN_UP_SCREEN) {
            SignUpScreen(navController = navController)
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen()
        }
    }
}