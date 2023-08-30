import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import com.example.lab5biancacalderon.EventGrid
import com.example.lab5biancacalderon.R
import com.example.lab5biancacalderon.ui.theme.Lab5BiancaCalderonTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5BiancaCalderonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val user = UserProfile(
                        "Bianca Dubon",
                        "@darkcat",
                        "Software Engineer",
                        R.drawable.iconprofile,
                        listOf("Imagine Dragons", "Dua Lipa", "The Vamps")
                    )
                    ProfileScreen(user = user)
                }
            }
        }
    }
}
@Composable
fun ProfileScreen(user: UserProfile, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.backgroundicon),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Image(
                painter = painterResource(id = user.profileImageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.BottomStart)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Espaciado flexible para centrar verticalmente
        ) {
            Spacer(modifier = Modifier.height(40.dp)) // Espaciado adicional
            Surface(
                color = Color.Cyan.copy(alpha = 0.1f),
                modifier = Modifier.fillMaxWidth(),
                contentColor = Color.Black
            ) {
                Text(
                    text = "User Details:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
            Text(
                text = user.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = user.username,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = user.occupation,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Surface(
                color = Color.Cyan.copy(alpha = 0.1f),
                modifier = Modifier.fillMaxWidth(),
                contentColor = Color.Black
            ) {
                Text(
                    text = "Favorites:",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }

            LazyColumn {
                items(user.favorites) { favorite ->
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "- $favorite",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
 //   Lab5BiancaCalderonTheme {
   //     val user = UserProfile(
     //       "Bianca Calderon",
         //   "@darkcat",
       //     "Software Engineer",
           // R.drawable.iconprofile,
            //listOf("Imagine Dragons", "Dua Lipa", "The Vamps")
        //)
        //ProfileScreen(user = user)
    //}
//}

