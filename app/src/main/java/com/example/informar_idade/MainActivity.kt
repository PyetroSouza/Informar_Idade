package com.example.informar_idade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.informar_idade.ui.theme.Informar_IdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Informar_IdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentScreen(
                        modifier = Modifier
                            .padding((innerPadding))
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentScreen(modifier: Modifier = Modifier) {
    var contador by remember { mutableStateOf(1) }
    var maioridade by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Qual é a sua idade?",
            fontSize = 30.sp,
            color = Color(0xFF4959AF)
        )
        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 17.sp,
            color = Color(0xFF313136)

        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = contador.toString(),
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (contador >= 180)
                        contador = 0
                    else
                        contador++
                },
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp), shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF4959AF),
                )
            ) {
                Text(text = "+", fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                onClick = {
                    if (contador <= 0)
                        contador = 0
                    else {
                        contador--
                    }
                },
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp), shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF4959AF),
                )
            ) {
                Text(
                    text = "-", fontSize = 30.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (contador < 18) {
                maioridade = "MENOR"
            } else {
                maioridade = "MAIOR"
            }

            Text(
                text = "Você ${maioridade} de idade",
                fontSize = 25.sp,
                color = Color(0xFF4959AF)
            )
        }

    }
}

