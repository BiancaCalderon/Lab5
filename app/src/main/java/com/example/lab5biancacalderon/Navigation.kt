package com.example.lab5biancacalderon

import android.provider.ContactsContract
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.engage.social.datamodel.Profile


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route,
        modifier = modifier) {
        composable(route = NavigationState.Home.route) {
            EventGrid(
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                navController = navController
            )
        }
        composable(route = NavigationState.Detail.route) {
            Detail(navController = navController)
        }
        composable(route = NavigationState.Events.route) {
            MainScreen(navController = navController)
        }
        composable(route = NavigationState.Profile.route) {
            ContactsContract.Profile(navController = navController)
        }
    }
}

@Composable
fun Detail(navController: NavHostController) {
    TODO("Not yet implemented")
}

@Composable
fun MainScreen(navController: NavHostController) {
    TODO("Not yet implemented")
}
