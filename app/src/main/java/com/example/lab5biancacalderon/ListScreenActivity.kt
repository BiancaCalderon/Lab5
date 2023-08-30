package com.example.lab5biancacalderon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.lab5biancacalderon.Event
import com.example.lab5biancacalderon.R
import com.example.lab5biancacalderon.ui.theme.Lab5BiancaCalderonTheme

class ListScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5BiancaCalderonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val concertLocations = listOf(
                        ConcertLocation("Imagine Dragons", "Los Angeles, CA", R.drawable.eventconcert1),
                        ConcertLocation("Dua Lipa", "New York, NY", R.drawable.eventconcert2),
                        ConcertLocation("The Vamps", "London, UK", R.drawable.eventconcert3),
                        ConcertLocation("Martin Garrix", "Amsterdam, Netherlands", R.drawable.eventconcert4)
                    )
                    ListScreen(concertLocations = concertLocations)
                }
            }
        }
    }
}

@Composable
fun ListScreen(concertLocations: List<ConcertLocation>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        items(concertLocations) { location ->
            var isExpanded by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { isExpanded = !isExpanded }
                        .background(Color(0xFF613FD3))
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${location.bandName} - ${location.location}",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Icon(
                        painter = painterResource(id = if (isExpanded) R.drawable.ic_launcher_background else R.drawable.ic_launcher_background),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }

                if (isExpanded) {
                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = location.imageResourceId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(shape = MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ListScreenPreview() {
    //Lab5BiancaCalderonTheme {
        //val concertLocations = listOf(
            //ConcertLocation("Imagine Dragons", "Los Angeles, CA", R.drawable.eventconcert1),
            //ConcertLocation("Dua Lipa", "New York, NY", R.drawable.eventconcert2),
          //  ConcertLocation("The Vamps", "London, UK", R.drawable.eventconcert3),
        //    ConcertLocation("Martin Garrix", "Amsterdam, Netherlands", R.drawable.eventconcert4)
      //  )
    //    ListScreen(concertLocations = concertLocations)
  //  }
//}