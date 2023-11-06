package com.mu.tote_2024.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mu.tote_2024.screens.logon.LogonScreen
import com.mu.tote_2024.screens.main_screen.MainScreen
import com.mu.tote_2024.screens.splash_screen.SplashScreen
import com.mu.tote_2024.utils.Routes

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
            LogonScreen()
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen()
        }
    }
}