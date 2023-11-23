package com.mu.tote2024.domain.usecase

import com.mu.tote2024.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun signUp(email: String, password: String) =
        repository.signUp(email, password)

    suspend fun signIn(email: String, password: String) =
        repository.signIn(email, password)

    suspend fun signOut() = repository.signOut()
}