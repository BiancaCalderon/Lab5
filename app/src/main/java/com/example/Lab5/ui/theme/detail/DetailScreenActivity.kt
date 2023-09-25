package com.example.lab5biancacalderon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab6fnl.R
import com.example.lab6fnl.ui.theme.LAB6FNLTheme
import com.example.lab6fnl.ui.theme.concert.ConcertLocation


class DetailScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LAB6FNLTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val concertLocation = ConcertLocation(
                        "Imagine Dragons",
                        "Los Angeles, CA",
                        R.drawable.eventconcert1
                    )
                    DetailScreen()
                }
            }
        }
    }
}
@Composable
fun DetailScreen() {
    val concertLocation = ConcertLocation(
        "Imagine Dragons",
        "Los Angeles, CA",
        R.drawable.eventconcert1
    )

    Column(
        modifier = Modifier
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
                .background(Color.Black.copy(alpha = 0.10f))
                .padding(16.dp)
                .clickable { },
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

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "September 10, 2023",
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "8:00 P:M",
                textAlign = TextAlign.Right
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "About:   " +
                    "Imagine Dragons es una banda estadounidense de pop rock originaria de Las Vegas, " +
                    "Nevada. Está compuesta por Dan Reynolds, Wayne Sermon, Ben McKee y Daniel Platzman. " +
                    "Ganó el reconocimiento mundial con el lanzamiento de su álbum de estudio debut Night " +
                    "Visions, y con su canción \"It's Time\".",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            ),
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.padding_small))
                .fillMaxWidth()
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
    LAB6FNLTheme {
        DetailScreen()
    }
}


