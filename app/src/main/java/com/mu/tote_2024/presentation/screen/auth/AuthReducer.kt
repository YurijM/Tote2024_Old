package com.mu.tote_2024.presentation.screen.auth

import com.mu.tote_2024.domain.usecase.AuthUseCase
import com.mu.tote_2024.presentation.screen.base.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AuthReducer(
    initial: AuthState,
    val authUserCase: AuthUseCase,
    val viewModelScope: CoroutineScope
) : Reducer<AuthState, AuthEvent>(initialVal = initial) {
    override fun reduce(oldState: AuthState, event: AuthEvent) {
        when (event) {
            is AuthEvent.Default -> {
                setState(
                    oldState.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = null
                    )
                )
            }

            is AuthEvent.LoadingData -> {
                setState(
                    oldState.copy(
                        isLoading = true,
                        isSuccess = false
                    )
                )
            }

            is AuthEvent.OnSignUp -> {
                sendEvent(AuthEvent.LoadingData)
                viewModelScope.launch {
                    try {
                        authUserCase.signUp(email = event.email, password = event.password).collect { result ->
                            if (result.data != null) {
                                setState(
                                    oldState.copy(
                                        isLoading = false,
                                        isSuccess = true
                                    )
                                )
                            } else if (result.message != null) {
                                sendEvent(AuthEvent.OnShowError(result.message))
                            } else {
                                sendEvent(AuthEvent.LoadingData)
                            }
                        }
                    } catch (e: Exception) {
                        sendEvent(AuthEvent.OnShowError(e.message ?: "Ошибка регистрации"))
                    }
                }
            }

            is AuthEvent.OnSignIn -> {
                sendEvent(AuthEvent.LoadingData)
                viewModelScope.launch {
                    try {
                        authUserCase.signIn(email = event.email, password = event.password).collect { result ->
                            if (result.data != null) {
                                setState(
                                    oldState.copy(
                                        isLoading = false,
                                        isSuccess = true
                                    )
                                )
                            } else if (result.message != null) {
                                sendEvent(AuthEvent.OnShowError(result.message))
                            } else {
                                sendEvent(AuthEvent.LoadingData)
                            }
                        }
                    } catch (e: Exception) {
                        sendEvent(AuthEvent.OnShowError(e.message ?: "Ошибка авторизации"))
                    }
                }
            }

            is AuthEvent.OnSignOut -> {
                viewModelScope.launch {
                    try {
                        authUserCase.signOut()
                    } catch (e: Exception) {
                        sendEvent(AuthEvent.OnShowError(e.message ?: "Ошибка выхода из Firebase"))
                    }
                }
            }

            is AuthEvent.OnShowError -> {
                setState(
                    oldState.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = event.error
                    )
                )
            }
        }
    }

}