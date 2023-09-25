package com.example.lab6fnl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lab5biancacalderon.ListScreen
import com.example.lab5biancacalderon.ui.theme.view.FavoritesScreen
import com.example.lab6fnl.ui.theme.LAB6FNLTheme
import com.example.lab6fnl.navegacion.MyAppRoute
import com.example.lab6fnl.navegacion.MyAppTopLevelDestination
import com.example.lab6fnl.navegacion.TOP_LEVEL_DESTINATIONS
import com.example.lab6fnl.ui.theme.concert.Event
import com.example.lab6fnl.navegacion.MyAppNavigationActions
import com.example.lab6fnl.ui.theme.profile.ProfileScreen
import com.example.myapplication.R
import androidx.compose.foundation.layout.Column as Column1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAB6FNLTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navigateAction = remember(navController){
                        MyAppNavigationActions(navController)
                    }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val selectedDestination = navBackStackEntry?.destination?.route ?: MyAppRoute.HOME

                    MyAppContent(
                        navController = navController,
                        selectedDestination = selectedDestination,
                        navigateTopLevelDestination = navigateAction::navigateTo
                    )
                }
            }
        }
    }
}
@Composable
fun MyAppBottomNavigation(
    selectedDestination: String,
    navigateTopLevelDestination: (MyAppTopLevelDestination) ->Unit

){
    NavigationBar (modifier = Modifier.fillMaxWidth()){
        TOP_LEVEL_DESTINATIONS.forEach { destinations ->
            NavigationBarItem(
                selected = selectedDestination == destinations.route ,
                onClick = { navigateTopLevelDestination(destinations) },
                icon = {
                    Icon(imageVector = destinations.selectedIcon, contentDescription = stringResource(
                        id = destinations.iconTextId)
                    )
                }
            )
        }

    }

}

@Composable
fun MyAppContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedDestination: String,
    navigateTopLevelDestination: (MyAppTopLevelDestination) -> Unit
) {
    Row(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = MyAppRoute.HOME
            ) {
                composable(MyAppRoute.HOME) {
                    EventGrid(modifier, navController)
                }
                composable(MyAppRoute.PLACES) {
                    ListScreen()
                }
                composable(MyAppRoute.FAVORITES) {
                    FavoritesScreen()
                }
                composable(MyAppRoute.PROFILE) {
                    ProfileScreen()
                }
                MyAppBottomNavigation(
                    selectedDestination = selectedDestination,
                    navigateTopLevelDestination = navigateTopLevelDestination
                )
            }
        }
    }
}


@Composable
fun EventCard(event: Event,  modifier: Modifier = Modifier) {
        Card(
            modifier = modifier,

            ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(android.graphics.Color.parseColor("#fad9e4")))
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Column1 {
                    Image(
                        painter = painterResource(id = event.imageResourceId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .border(2.dp, androidx.compose.ui.graphics.Color.Black),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = event.name,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            top = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium),
                            bottom = dimensionResource(R.dimen.padding_small)
                        )
                    )
                    Text(
                        text = event.availableSeats.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }

@Composable
fun EventGrid(modifier: Modifier = Modifier)  {
    val events = listOf(
        Event("Imagine Dragons", 226, R.drawable.eventconcert1),
        Event("Dua Lipa", 150, R.drawable.eventconcert2),
        Event("The Vamps", 26, R.drawable.eventconcert3),
        Event("Martin Garrix", 48, R.drawable.eventconcert4)
    )

    val maxLineSpan = 2

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(android.graphics.Color.parseColor("#f2edf6")))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "TodoEventos",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(32.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                            .padding(8.dp)
                    )
                }
            }
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, androidx.compose.ui.graphics.Color.White)
                    .height(80.dp)
            ) {
                Text(
                    "Your Favorites",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.wrapContentSize(Alignment.Center)
                )
            }
        }
        items(events) { topic ->
            EventCard(topic)
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, androidx.compose.ui.graphics.Color.White)
                    .height(80.dp)
            ) {
                Text(
                    "All Concerts",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.wrapContentSize(Alignment.Center)
                )
            }
        }
        items(events) { topic ->
            EventCard(topic)
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        LAB6FNLTheme {
            EventGrid()
        }
    }
