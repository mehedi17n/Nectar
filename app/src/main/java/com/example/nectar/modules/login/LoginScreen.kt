package com.example.nectar.modules.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui
            .Alignment.CenterHorizontally
        ) {
        Button(onClick = { }) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
fun LoginScreenPrev(){
    LoginScreen()
}