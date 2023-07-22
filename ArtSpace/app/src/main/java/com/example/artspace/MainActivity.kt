package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceMain(modifier: Modifier = Modifier) {
    var numImage by remember { mutableStateOf(1) }
    val image = when (numImage) {
        1 -> R.drawable.newjeans_omg_hanni
        2 -> R.drawable.newjeans_omg_haerin
        3 -> R.drawable.newjeans_omg_minji
        4 -> R.drawable.newjeans_omg_hyein
        5 -> R.drawable.newjeans_omg_danielle
        else -> R.drawable.newjeans
    }

    val name = when (numImage) {
        1 -> R.string.name_hanni
        2 -> R.string.name_haerin
        3 -> R.string.name_minji
        4 -> R.string.name_hyein
        5 -> R.string.name_danielle
        else -> R.string.name_newjeans
    }

    val birth = when (numImage) {
        1 -> R.string.birth_hanni
        2 -> R.string.birth_haerin
        3 -> R.string.birth_minji
        4 -> R.string.birth_hyein
        5 -> R.string.birth_danielle
        else -> R.string.birth_newjeans
    }

    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            Modifier
                .weight(8f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                border = BorderStroke(2.dp, Color.Gray),
                shadowElevation = 8.dp
            ) {
                Image(
                    painter = painterResource(image) ,
                    contentDescription = "Hanni",
                    modifier = Modifier.padding(30.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Surface(
            Modifier
                .weight(1f),
            shadowElevation = 8.dp,
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(name),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(birth))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    if (numImage > 1) {
                        numImage--
                    }
                }
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    if (numImage < 6) {
                        numImage++
                    }
                }
            ) {
                Text(text = "Next")
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceTheme {
        ArtSpaceMain(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}


//// Gambar
//Surface(
//modifier = Modifier.padding(15.dp),
//border = BorderStroke(2.dp, Color.Gray),
//shadowElevation = 8.dp
//) {
//    Image(
//        painter = image ,
//        contentDescription = "Hanni",
//        modifier = Modifier.padding(30.dp),
//        contentScale = ContentScale.Fit
//    )
//}
//
//// Keterangan
//Surface(
//modifier = Modifier.padding(20.dp),
//shadowElevation = 8.dp,
//) {
//    Column(
//        modifier = Modifier
//            .padding(10.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Artwork Title",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Text(text = "Artwork Artist (Year)")
//    }
//}
//
//// Button
//Row(
//modifier = Modifier
//.fillMaxWidth(),
//horizontalArrangement = Arrangement.SpaceEvenly,
//verticalAlignment = Alignment.Bottom
//) {
//    Button(onClick = { /*TODO*/ }) {
//        Text(text = "Previous")
//    }
//    Button(onClick = { /*TODO*/ }) {
//        Text(text = "Next")
//    }
//}