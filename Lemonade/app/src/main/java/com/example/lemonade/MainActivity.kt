package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun lemonadeStep(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var angka by remember { mutableStateOf(1) }
        val textStep = when (angka) {
            1 -> R.string.lemon_tree
            2 -> R.string.lemon
            3 -> R.string.glass
            else -> R.string.empty
        }
        Text(
            text = stringResource(textStep),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        val image = when (angka) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        var squeeze by remember { mutableStateOf(0) }
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .border(1.dp, Color(0xff69cdd8), RectangleShape)
                .clickable {
                    if (squeeze != 0) {
                        squeeze--
                    } else if (angka == 1) {
                        squeeze = (2..4).random()
                        angka++
                    } else if (angka == 4) {
                        angka = 1
                    } else {
                        angka++
                    }
                }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    lemonadeStep(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}