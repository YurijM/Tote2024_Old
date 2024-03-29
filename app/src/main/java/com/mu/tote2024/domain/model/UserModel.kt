package com.mu.tote2024.domain.model

import com.mu.tote2024.utils.Constants.EMPTY

data class UserModel(
    val userId: String? = null,
    val nickname: String = "",
    val email: String = "",
    val photoUrl: String = EMPTY, // для Picasso поле не должно быть пустым
    val gender: String = "",
    val rate: Int = 0,
    val pointsPrev: Double = 0.00,
    val points: Double = 0.00,
    val placePrev: Int = 0,
    val place: Int = 0,
    val isAdmin: Boolean = false
)
