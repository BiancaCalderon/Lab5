package com.example.lab6fnl.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.lab6fnl.FavoritesScreen
import com.example.lab6fnl.HomeScreen
import com.example.lab6fnl.PlacesScreen
import com.example.lab6fnl.ProfileScreen
import com.example.lab6fnl.ui.theme.ComposableFun

sealed class TabItem (val title:String, val icon: ImageVector, val screens: ComposableFun){

    object Home: TabItem("Home", icon = Icons.Default.Home, screens = { HomeScreen() })
    object Places: TabItem("Places", icon = Icons.Default.Place, screens = { PlacesScreen() })
    object Favorites: TabItem("Favorites", icon = Icons.Default.Favorite, screens = { FavoritesScreen() })
    object Profile: TabItem("Profile", icon = Icons.Default.AccountCircle, screens = { ProfileScreen() })
}