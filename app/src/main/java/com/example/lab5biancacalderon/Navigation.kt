package com.example.lab5biancacalderon

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
/**
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = Screen.Concerts.route
    ) {
        composable(Screen.Concerts.route) {
            ConcertsScreen(actions.navigateToDetail)
        }
        composable(Screen.Locations.route) {
            LocationsScreen(actions.navigateToDetail)
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
        composable(Screen.Favorites.route) {
            FavoritesScreen()
        }
        composable(Screen.Detail.route) {
            val eventId = it.arguments?.getString("eventId")
            DetailScreen(eventId)
        }
    }
}

**/