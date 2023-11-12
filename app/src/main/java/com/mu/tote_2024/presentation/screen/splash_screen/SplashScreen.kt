package com.mu.tote_2024.presentation.screen.splash_screen

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mu.tote_2024.R
import com.mu.tote_2024.presentation.theme.ColorApplication
import com.mu.tote_2024.presentation.theme.ColorBackgroundLight
import com.mu.tote_2024.utils.Routes
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedAnimatable")
@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember {
        Animatable(0f)
    }
    val scaleText = remember {
        Animatable(0f)
    }

    val developmentText = "Разаботка "
    val companyText = "MU & C°"
    val text = buildAnnotatedString {
        append(developmentText)
        withStyle(
            style = SpanStyle(fontWeight = FontWeight.Bold)
        ) {
            pushStringAnnotation(tag = companyText, annotation = companyText)
            append(companyText)
        }
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 3000,
                easing = {
                    OvershootInterpolator(10f).getInterpolation(it)
                }
            )
        )
        scaleText.animateTo(
            targetValue = .85f,
            animationSpec = tween(
                durationMillis = 3000,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(1000L)
        navController.navigate(Routes.LOGON_SCREEN) {
            popUpTo(Routes.SPLASH_SCREEN) {
                inclusive = true
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = ColorBackgroundLight
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.scale(scale.value),
                painter = painterResource(id = R.drawable.author),
                contentDescription = "Logo"
            )
            AssistChip(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .scale(scaleText.value),
                border = AssistChipDefaults.assistChipBorder(
                    borderColor = ColorApplication
                ),
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Color.White,
                    leadingIconContentColor = ColorApplication,
                    labelColor = ColorApplication,
                ),
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = text,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "settings"
                    )
                }
            )
        }
    }
}