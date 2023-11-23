package com.mu.tote2024.utils

import com.google.firebase.database.DatabaseReference
import com.mu.tote2024.domain.model.UserModel

object Constants {
    const val DEBUG_TAG = "tote2024"
    const val EMPTY = "empty"
    const val YEAR_START = 2023
    const val MIN_PASSWORD_LENGTH = 6

    object Routes {
        const val SPLASH_SCREEN = "splash_screen"
        const val MAIN_SCREEN = "main_screen"
        const val LOGON_SCREEN = "logon_screen"
        const val SIGN_UP_SCREEN = "sign_up_screen"
        const val SIGN_IN_SCREEN = "sign_in_screen"
        const val RATING_SCREEN = "rating_screen"
        const val STAKES_SCREEN = "stakes_screen"
        const val PROGNOSIS_SCREEN = "prognosis_screen"
        const val GAMES_SCREEN = "games_screen"
    }

    lateinit var REF_DB_ROOT: DatabaseReference

    var CURRENT_ID = ""
    var GAMBLER = UserModel()

    const val NODE_GAMBLERS = "gamblers"
}