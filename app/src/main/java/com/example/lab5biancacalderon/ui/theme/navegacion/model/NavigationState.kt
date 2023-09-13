package com.example.lab5biancacalderon.ui.theme.navegacion.model

sealed class NavigationState(val route: String) {
    object Home : NavigationState("Home")
    object Events : NavigationState("Events")
    object Detail : NavigationState("Places")
    object Profile : NavigationState("Profile")
    object Favorites : NavigationState("Favorites")
}
