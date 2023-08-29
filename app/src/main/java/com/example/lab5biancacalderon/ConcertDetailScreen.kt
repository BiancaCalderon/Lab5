package com.example.lab5biancacalderon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun ConcertDetailScreen(concert: Concert) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = concert.imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = concert.title, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
        Text(text = concert.date, style = TextStyle(fontSize = 16.sp))
        Text(text = concert.description, style = TextStyle(fontSize = 16.sp))

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ubicaciones:",
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
        )
        concert.locations.forEach { location ->
            Text(text = location, style = TextStyle(fontSize = 14.sp))
        }
    }
}

val selectedConcert = Concert(
    title = "Concierto de Imagine Dragons",
    subtitle = "Imagine Dragons en vivo",
    imageResId = R.drawable.eventconcert1,
    date = "Fecha y hora",
    description = "Descripción del concierto de Imagine Dragons",
    locations = listOf("New York", "Portland"),
    isFavorite = true
)
