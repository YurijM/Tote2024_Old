package com.mu.tote2024.presentation.screen.auth

import androidx.lifecycle.viewModelScope
import com.mu.tote2024.domain.usecase.AuthUseCase
import com.mu.tote2024.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUserCase: AuthUseCase
) : BaseViewModel<AuthState, AuthEvent>() {
    override val state: StateFlow<AuthState>
        get() = reducer.state

    private val reducer = AuthReducer(
        initial = AuthState.initial(),
        authUserCase = authUserCase,
        viewModelScope = viewModelScope
    )

    fun sendEvent(event: AuthEvent) {
        reducer.sendEvent(event)
    }
}