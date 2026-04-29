package com.example.mycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorUI()
        }
    }
}

@Composable
fun CalculatorUI() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "BASIC CALCULATOR",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Insert first number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Insert second number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {

            CalcButton("+") {
                try {
                    result = (num1.toDouble() + num2.toDouble()).toString()
                } catch (e: Exception) {
                    result = "Input Invalid"
                }
            }

            CalcButton("-") {
                try {
                    result = (num1.toDouble() - num2.toDouble()).toString()
                } catch (e: Exception) {
                    result = "Input Invalid"
                }
            }

            CalcButton("x") {
                try {
                    result = (num1.toDouble() * num2.toDouble()).toString()
                } catch (e: Exception) {
                    result = "Input Invalid"
                }
            }

            CalcButton("/") {
                try {
                    result = if (num2 != "0") {
                        (num1.toDouble() / num2.toDouble()).toString()
                    } else {
                        "Error (Dibagi 0)"
                    }
                } catch (e: Exception) {
                    result = "Input Invalid"
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                num1 = ""
                num2 = ""
                result = "0"
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text(text = "Clear", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Result: $result",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CalcButton(symbol: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .width(70.dp)
            .height(50.dp)
    ) {
        Text(text = symbol, fontSize = 18.sp)
    }
}