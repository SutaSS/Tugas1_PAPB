package com.example.pertemuan2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan2.ui.theme.Pertemuan2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pertemuan2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    GreetingScreen(modifier = Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingButton (onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Klik Ini BosKu")
    }
}

@Composable
fun GreetingScreen(modifier: Modifier = Modifier) {
    var name by remember {
        mutableStateOf("android")
    }

    Column(modifier = modifier.fillMaxSize()) {
        Greeting(name = name)
        GreetingButton(onClick = {name = "Andika"})
    }
}

@Composable
fun Profile (modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Gambar Profil",
            modifier = Modifier.size(120.dp).clip(CircleShape).border(2.dp, color = Color.Blue, CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Andika", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Developer Sigma", fontSize = 24.sp, fontWeight = FontWeight.Light)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pertemuan2Theme {
        Profile(Modifier.padding(16.dp))
    }
}