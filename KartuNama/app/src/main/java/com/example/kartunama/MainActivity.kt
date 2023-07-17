package com.example.kartunama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kartunama.ui.theme.KartuNamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KartuNamaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KartuNama()
                }
            }
        }
    }
}

@Composable
fun KartuNama() {
    Column(
        modifier = Modifier
            .background(Color(0xFF073042))
            .padding(top = 250.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // foto profile
            var profileImage = painterResource(id = R.drawable.android_logo)
            Image(
                painter = profileImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            // nama lengkap
            Text(
                text = "Firdan Fescara",
                fontWeight = FontWeight.Light,
                fontSize = 36.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 6.dp)
            )
            // title
            Text(
                text = "Belajar Android Developer",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF3DDC84)
            )
        }

        Spacer(modifier = Modifier.height(200.dp))
        
        Column() {
            Divider(color = Color(0xFFa8acb3), thickness = 1.dp)
            // icon + no hp
            Row(
                modifier = Modifier
                    .padding(start = 50.dp, top = 6.dp, bottom = 6.dp)
            ) {
                Icon(Icons.Rounded.Call, contentDescription = "Kontak", tint = Color(0xFF3DDC84))
                Text(
                    text = "08123456789",
                    color = Color.White,
                    modifier = Modifier.padding(start = 18.dp)
                )
            }
            Divider(color = Color(0xFFa8acb3), thickness = 1.dp)
            // icon + sosial media
            Row(modifier = Modifier
                    .padding(start = 50.dp, top = 6.dp, bottom = 6.dp)
            ) {
                Icon(Icons.Rounded.Person, contentDescription = "Sosial Media", tint = Color(0xFF3DDC84))
                Text(
                    text = "@ffescara",
                    color = Color.White,
                    modifier = Modifier.padding(start = 18.dp)
                )
            }
            Divider(color = Color(0xFFa8acb3), thickness = 1.dp)
            // icon + email
            Row(modifier = Modifier
                    .padding(start = 50.dp, top = 6.dp)
            ) {
                Icon(Icons.Rounded.Email, contentDescription = "Email", tint = Color(0xFF3DDC84))
                Text(
                    text = "ffescara27@gmail.com",
                    color = Color.White,
                    modifier = Modifier.padding(start = 18.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    KartuNamaTheme {
        KartuNama()
    }
}