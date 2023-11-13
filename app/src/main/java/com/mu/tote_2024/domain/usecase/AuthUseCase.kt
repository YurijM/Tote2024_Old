package com.mu.tote_2024.domain.usecase

import com.mu.tote_2024.data.firebase.AuthRepositoryImpl
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepositoryImpl
) {
    suspend fun signUp(email: String, password: String) =
        repository.signUp(email, password)

    suspend fun signIn(email: String, password: String) =
        repository.signIn(email, password)

    suspend fun signOut() = repository.signOut()
}