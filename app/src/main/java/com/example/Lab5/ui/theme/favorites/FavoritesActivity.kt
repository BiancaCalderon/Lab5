package com.example.lab5biancacalderon.ui.theme.view

import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5biancacalderon.ui.theme.ui.favorites.FavoriteConcert
import com.example.lab6fnl.R
import com.example.lab6fnl.ui.theme.LAB6FNLTheme

class FavoritesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAB6FNLTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val favoriteConcerts = listOf(
                        FavoriteConcert("Imagine Dragons", R.drawable.eventconcert1),
                        FavoriteConcert("Dua Lipa", R.drawable.eventconcert2),
                        FavoriteConcert("The Vamps", R.drawable.eventconcert3),
                        FavoriteConcert("Martin Garrix", R.drawable.eventconcert4)
                    )
                    FavoritesScreen()
                }
            }
        }
    }
}

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    val favoriteConcerts = listOf(
        FavoriteConcert("Imagine Dragons", R.drawable.eventconcert1),
        FavoriteConcert("Dua Lipa", R.drawable.eventconcert2),
        FavoriteConcert("The Vamps", R.drawable.eventconcert3),
        FavoriteConcert("Martin Garrix", R.drawable.eventconcert4)
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        items(favoriteConcerts) { concert ->
            FavoriteConcertCard(concert)
        }
    }
}


@Composable
fun FavoriteConcertCard(concert: FavoriteConcert, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(android.graphics.Color.parseColor("#fad9e4")))
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Column {
                Image(
                    painter = painterResource(id = concert.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .border(2.dp, Color.Black),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = concert.name,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = "Favorite",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FavoriteConcertsListPreview() {
    val favoriteConcerts = listOf(
        FavoriteConcert("Imagine Dragons", R.drawable.eventconcert1),
        FavoriteConcert("Dua Lipa", R.drawable.eventconcert2),
        FavoriteConcert("The Vamps", R.drawable.eventconcert3),
        FavoriteConcert("Martin Garrix", R.drawable.eventconcert4)
    )

    LazyColumn {
        items(favoriteConcerts) { concert ->
            FavoriteConcertCard(concert = concert)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}




