package com.mu.tote_2024.data.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.mu.tote_2024.domain.model.NetworkResult
import com.mu.tote_2024.domain.repository.AuthRepository
import com.mu.tote_2024.utils.Constants.CURRENT_ID
import com.mu.tote_2024.utils.Constants.DEBUG_TAG
import com.mu.tote_2024.utils.Constants.GAMBLER
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase
) : AuthRepository {
    override suspend fun signUp(email: String, password: String): Flow<NetworkResult<Boolean>> {
        return flow {
            emit(NetworkResult.Loading())

            try {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = firebaseAuth.currentUser

                            if (user != null) {
                                CURRENT_ID = user.uid
                                GAMBLER = GAMBLER.copy(
                                    userId = user.uid,
                                    email = email
                                )
                            }

                            Log.d(DEBUG_TAG, "Успешная регистрация участника (uid = $CURRENT_ID)")
                        } else {
                            Log.d(DEBUG_TAG, "Ошибка при регистрации участника: ${task.exception}")
                        }
                    }.await()

                if (CURRENT_ID.isNotBlank()) {
                    emit(NetworkResult.Success(true))
                } else {
                    emit(NetworkResult.Fail("Ошибка при регистрации участника"))
                }
            } catch(e: Exception) {
                emit(NetworkResult.Fail(message = "Исключительная ситуация при регистрации участника: ${e.localizedMessage ?: "что-то пошло не так"}"))
            }
        }
    }

    override suspend fun signIn(email: String, password: String): Flow<NetworkResult<Boolean>> {
        return flow {
            emit(NetworkResult.Loading())

            try {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = firebaseAuth.currentUser

                            if (user != null) {
                                CURRENT_ID = firebaseAuth.currentUser?.uid ?: ""
                                TODO("Прочитать ветку данного игрока и записать в GAMBLER")
                            }

                            Log.d(DEBUG_TAG, "Успешная авторизация участника (uid = $CURRENT_ID)")
                        } else {
                            Log.d(DEBUG_TAG, "Исключительная ситуация при авторизация участника: ${task.exception}")
                        }
                    }.await()

                if (GAMBLER.userId != null) {
                    emit(NetworkResult.Success(true))
                } else {
                    emit(NetworkResult.Fail("Ошибка при авторизации участника"))
                }

            } catch(e: Exception) {
                emit(NetworkResult.Fail(message = "Исключительная ситуация при авторизации участника: ${e.localizedMessage ?: "что-то пошло не так"}"))
            }
        }
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }
}