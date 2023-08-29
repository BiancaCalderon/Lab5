package com.example.lab5biancacalderon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConcertListScreen(concerts: List<Concert>) {
    LazyColumn {
        items(concerts) { concert ->
            ConcertCard(concert)
        }
    }
}

@Composable
fun ConcertCard(concert: Concert) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Imagen del concierto
        Image(
            painter = painterResource(id = concert.imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título y Subtítulo
        Text(text = concert.title, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
        Text(text = concert.subtitle, style = TextStyle(fontSize = 16.sp))

        Spacer(modifier = Modifier.height(8.dp))

        // Fecha y Descripción
        Text(text = concert.date, style = TextStyle(fontSize = 16.sp))
        Text(text = concert.description, style = TextStyle(fontSize = 16.sp))

        Spacer(modifier = Modifier.height(8.dp))

        // Lugares
        Text(
            text = "Ubicaciones:",
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
        )
        concert.locations.forEach { location ->
            Text(text = location, style = TextStyle(fontSize = 14.sp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Favorito
        if (concert.isFavorite) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
        }
    }
}
val concerts = listOf(
    Concert(
        title = "Concierto de Imagine Dragons",
        subtitle = "Imagine Dragons en vivo",
        imageResId = com.example.lab5biancacalderon.R.drawable.eventconcert1,
        date = "Fecha y hora",
        description = "Descripción del concierto de Imagine Dragons",
        locations = listOf("Ubicación 1", "Ubicación 2"),
        isFavorite = true
    ),
    Concert(
        title = "Concierto de Dua Lipa",
        subtitle = "Dua Lipa en concierto",
        imageResId = com.example.lab5biancacalderon.R.drawable.eventconcert2,
        date = "Fecha y hora",
        description = "Descripción del concierto de Dua Lipa",
        locations = listOf("Ubicación 1", "Ubicación 2"),
        isFavorite = false
    ),
    Concert(
        title = "Concierto de The Vamps",
        subtitle = "The Vamps en directo",
        imageResId = com.example.lab5biancacalderon.R.drawable.eventconcert3,
        date = "Fecha y hora",
        description = "Descripción del concierto de The Vamps",
        locations = listOf("Ubicación 1", "Ubicación 2"),
        isFavorite = true
    )
)
