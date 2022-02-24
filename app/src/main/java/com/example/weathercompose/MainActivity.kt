package com.example.weathercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercompose.ui.theme.DarkBlue
import com.example.weathercompose.ui.theme.LightGray
import com.example.weathercompose.ui.theme.VeryLightGray
import com.example.weathercompose.ui.theme.WeatherComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    WeatherPage()
                }
            }
        }
    }
}

@Composable
fun WeatherPage() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(top = 64.dp, end = 16.dp, start = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderImage()
        MainInfo()
        InfoTable()
    }
}

@Composable
fun HeaderImage(){
    Image(
        painter = painterResource(id = R.drawable.image2),
        contentDescription = null,
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
    )
}

@Composable
fun MainInfo(){
    Column(
        modifier = Modifier.padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "11°",
            color = DarkBlue,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Tashkent City, TC",
            color = DarkBlue,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "bulutli va yomg'rli.\nShamol sharqdan \n10 - 15 km/h tezlikda esadi",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }
}

@Composable
fun InfoTable(){
    Column (modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(4.dp))
        .background(VeryLightGray)){
        Row(modifier = Modifier.padding(16.dp)){
           InfoItem(
               iconRes = R.drawable.ic_humidity_alt,
               title = "Yomg'rili",
               subtitle = "85%",
               modifier = Modifier.weight(1f)
           )
           InfoItem(
               iconRes = R.drawable.ic_sun_svgrepo_com,
               title = "Quyoshli",
               subtitle = "14 dan 16 gacha",
               modifier = Modifier.weight(1f)
           )
        }
        Divider(color = LightGray)
        Row(modifier = Modifier.padding(16.dp)){
           InfoItem(
               iconRes = R.drawable.ic_sun_svgrepo_com,
               title = "Salqin",
               subtitle = "7:30",
               modifier = Modifier.weight(1f)
           )
           InfoItem(
               iconRes = R.drawable.ic_humidity_alt,
               title = "Sovuq",
               subtitle = "20:00",
               modifier = Modifier.weight(1f)
           )
        }
    }
}

@Composable
fun InfoItem(
    @DrawableRes iconRes: Int,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
){
    Row(modifier = modifier) {
        Image(painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 16.dp)
                .width(40.dp))
        Column {
            Text(text = title, color = Color.Gray)
            Text(text = subtitle, color = DarkBlue, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun DefaultPreview() {
    WeatherComposeTheme {
        WeatherPage()
    }
}