package com.mu.tote_2024.presentation.screen.main_screen

import com.mu.tote_2024.R
import com.mu.tote_2024.utils.Constants.Routes

sealed class BottomNavItem(
    val titleId: Int,
    val iconId: Int,
    val route: String
) {
    object RatingItem: BottomNavItem(
        titleId = R.string.rating,
        iconId = R.drawable.ic_rating,
        route = Routes.RATING_SCREEN
    )
    object StakeItem: BottomNavItem(
        titleId = R.string.stake,
        iconId = R.drawable.ic_ruble,
        route = Routes.STAKES_SCREEN
    )
    object PrognosisItem: BottomNavItem(
        titleId = R.string.prognosis,
        iconId = R.drawable.ic_prognosis,
        route = Routes.PROGNOSIS_SCREEN
    )
    object GamesItem: BottomNavItem(
        titleId = R.string.games,
        iconId = R.drawable.ic_games,
        route = Routes.GAMES_SCREEN
    )
}
