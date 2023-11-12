package com.mu.tote_2024.presentation.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mu.tote_2024.R
import com.mu.tote_2024.presentation.theme.ColorApplication
import com.mu.tote_2024.presentation.theme.ColorBackgroundLight

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    Surface (
        modifier = Modifier
            .fillMaxSize(),
        color = ColorBackgroundLight,
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight(.5f)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.sign_up),
                color = ColorApplication,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(28.dp))
        }

    }
}