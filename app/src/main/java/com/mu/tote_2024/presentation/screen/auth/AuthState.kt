package com.mu.tote_2024.presentation.screen.auth

import com.mu.tote_2024.presentation.screen.base.UiState
import javax.annotation.concurrent.Immutable

@Immutable
data class AuthState(
    val isLoading: Boolean,
    val isSuccess: Boolean,
    val error: String?,
): UiState {
    companion object {
        fun initial() = AuthState(
            isLoading = false,
            isSuccess = false,
            error = null
        )
    }
}