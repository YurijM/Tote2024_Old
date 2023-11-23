package com.mu.tote2024.domain.repository

import com.mu.tote2024.domain.model.NetworkResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signUp(email: String, password: String): Flow<NetworkResult<Boolean>>
    suspend fun signIn(email: String, password: String): Flow<NetworkResult<Boolean>>
    suspend fun signOut()
}