package com.example.greetingcard

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingcardTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingcardTheme {
                Tarjeta()
            }
        }
    }
}

@Composable
fun Tarjeta(modifier: Modifier = Modifier) {
    val backgroundImage = painterResource(R.drawable.background_image) // fondo
    val foregroundImage = painterResource(R.drawable.images2)

    Box(modifier = modifier.fillMaxSize()) {
        // Imagen de fondo
        Image(
            painter = backgroundImage,
            contentDescription = "Fondo de Tarjeta",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // imagen para cubrir todo el espacio
        )

        // Contenido de la tarjeta
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray.copy(alpha = 0.7f)), // Fondo semi-transparente para mejorar la legibilidad
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = foregroundImage, contentDescription = "Imagen de Tarjeta")

            Text("ALEXANDRA NANCY LIMA QUISPE", fontSize = 20.sp)
            Text("DIANA MARYSABELL LLAMOCA ZÁRATE", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("UPCH", fontSize = 30.sp)
            Spacer(modifier = Modifier.height(16.dp))
            // Sección de contacto
            ContactInfo(
                iconResourceId = R.drawable.telefono,
                text1 = "+51 988954149",
                text2 = "+51 960971324"
            )
            Spacer(modifier = Modifier.height(16.dp))
            ContactInfo(
                iconResourceId = R.drawable.github,
                text1 = "Alexandralima16",
                text2 = "DianaLlamoca"
            )
            Spacer(modifier = Modifier.height(16.dp))
            ContactInfo(
                iconResourceId = R.drawable.gmail,
                text1 = "alexandra.lima@upch.pe",
                text2 = "dianallamoca@upch.pe"
            )

        }
    }
}

@Composable
fun ContactInfo(iconResourceId: Int, text1: String, text2: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconResourceId),
            contentDescription = "Icono de contacto",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text1, fontSize = 22.sp)
            Text(text2, fontSize = 22.sp)
        }
    }
}

