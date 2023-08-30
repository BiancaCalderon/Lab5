package com.example.lab5biancacalderon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5biancacalderon.R
import com.example.lab5biancacalderon.ui.theme.Lab5BiancaCalderonTheme


class DetailScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5BiancaCalderonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val concertLocation = ConcertLocation(
                        "Imagine Dragons",
                        "Los Angeles, CA",
                        R.drawable.eventconcert1
                    )
                    DetailScreen(concertLocation = concertLocation)
                }
            }
        }
    }
}

@Composable
fun DetailScreen(concertLocation: ConcertLocation, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        Image(
            painter = painterResource(id = concertLocation.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RectangleShape)
                .background(Color.Blue.copy(alpha = 0.5f))
                .padding(16.dp)
                .clickable { /* Handle click if needed */ },
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = concertLocation.bandName,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = concertLocation.location
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Date and Time: September 10, 2023 - 8:00 PM"
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "About: Imagine Dragons es una banda estadounidense de pop rock originaria de Las Vegas, " +
                    "Nevada. Está compuesta por Dan Reynolds, Wayne Sermon, Ben McKee y Daniel Platzman. " +
                    "Ganó el reconocimiento mundial con el lanzamiento de su álbum de estudio debut Night " +
                    "Visions, y con su canción \"It's Time\"."
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = "Favorite")
            }
            Button(
                onClick = { },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Buy")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Lab5BiancaCalderonTheme {
        val concertLocation = ConcertLocation(
            "Imagine Dragons",
            "Los Angeles, CA",
            R.drawable.eventconcert1
        )
        DetailScreen(concertLocation = concertLocation)
    }
}
