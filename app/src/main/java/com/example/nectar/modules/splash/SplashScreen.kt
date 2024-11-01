package com.example.nectar.modules.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nectar.R

@Composable
fun SplashScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.primaryColor)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui
            .Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_nectar_logo_name),
            contentDescription = "Splash Image",
            modifier = Modifier.height(70.dp).width(268.dp)
        )
    }
}

@Preview
@Composable
fun SplashScreenPrev(){
    SplashScreen()
}