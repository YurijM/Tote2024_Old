package com.mu.tote_2024.screens.main_screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mu.tote_2024.ui.theme.ColorBackgroundLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        containerColor = ColorBackgroundLight,
        bottomBar = {
            BottomNav()
        },
        topBar = {
            ApplicationBar()
        }
    ) {

    }
}
