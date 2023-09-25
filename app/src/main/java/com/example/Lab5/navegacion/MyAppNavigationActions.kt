package com.example.lab6fnl.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.myapplication.R


class MyAppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: MyAppTopLevelDestination){
        navController.navigate(destination.route){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
        }
    }
}


data class MyAppTopLevelDestination (  val route: String,
                                       val selectedIcon: ImageVector,
                                       val iconTextId: Int
) {

}

val TOP_LEVEL_DESTINATIONS = listOf(
    MyAppTopLevelDestination(
        route = MyAppRoute.HOME,
        selectedIcon = Icons.Default.Home,
        iconTextId = R.string.home,
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.PLACES,
        selectedIcon = Icons.Default.Place,
        iconTextId = R.string.places,
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.FAVORITES,
        selectedIcon = Icons.Default.Favorite,
        iconTextId = R.string.favorites,
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.PROFILE,
        selectedIcon = Icons.Default.AccountCircle,
        iconTextId = R.string.profile,
    ),
)

object MyAppRoute {
    const val HOME = "Home"
    const val PLACES = "Places"
    const val FAVORITES = "Favorites"
    const val PROFILE = "Profile"

}