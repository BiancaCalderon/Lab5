package com.example.lab5biancacalderon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(userProfile: UserProfile) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = userProfile.profileImageResId),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = userProfile.name, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Favoritos:",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
        )
        userProfile.favoriteConcerts.forEach { concert ->
            Text(text = concert.title, style = TextStyle(fontSize = 16.sp))
        }
    }
}
val user = UserProfile(
    name = "Nombre de Usuario",
    profileImageResId = R.drawable.iconprofile,
    favoriteConcerts = listOf(
        Concert(
            "Imagine Dragons",
            "Radioactive tour",
            R.drawable.eventconcert1,
            "December 15th",
            "At Luna Concert Park",
            listOf("New York", "Portland"),
            true
        )
    )
)
