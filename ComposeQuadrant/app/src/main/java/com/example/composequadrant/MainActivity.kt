package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Kuadran()
                }
            }
        }
    }
}

@Composable
fun Kuadran() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            IsiKuadran(
                judul = stringResource(R.string.judul_satu),
                isi = stringResource(R.string.isi_satu),
                warna = Color.Green,
                modifier = Modifier.weight(1f)
            )
            IsiKuadran(
                judul = stringResource(R.string.judul_dua),
                isi = stringResource(R.string.isi_dua),
                warna = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            IsiKuadran(
                judul = stringResource(R.string.judul_tiga),
                isi = stringResource(R.string.isi_tiga),
                warna = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            IsiKuadran(
                judul = stringResource(R.string.judul_empat),
                isi = stringResource(R.string.isi_empat),
                warna = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun IsiKuadran(judul: String, isi: String, warna: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(warna)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = judul,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = isi,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Kuadran()
    }
}