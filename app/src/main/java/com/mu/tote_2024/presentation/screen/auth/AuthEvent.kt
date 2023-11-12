package com.mu.tote_2024.presentation.screen.auth

import androidx.compose.runtime.Immutable
import com.mu.tote_2024.presentation.screen.base.UiEvent

@Immutable
sealed class AuthEvent : UiEvent {
    object Default : AuthEvent()
    object LoadingData : AuthEvent()
    data class OnSignUp(val email: String, val password: String) : AuthEvent()
    data class OnSignIn(val email: String, val password: String) : AuthEvent()
    object OnSignOut : AuthEvent()
    data class OnShowError(val error: String) : AuthEvent()
}