package com.example.nectar.modules.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nectar.R
import com.example.nectar.modules.components.CustomButton
import com.example.nectar.modules.navigation.ScreenRoot
import com.example.nectar.ui.theme.gilroyFontFamily

@Composable
fun OnboardingScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp),
            contentAlignment = Alignment.BottomCenter
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp)

            ) {
                Image(
                    modifier = Modifier.padding(bottom = 16.dp),
                    painter = painterResource(id = R.drawable.ic_nectar_logo),
                    contentDescription = null
                )
                Text(
                    text = "Welcome\nTo Our Store",
                    color = Color.White,
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 48.sp,
                    lineHeight = 50.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(5.dp).padding(bottom = 5.dp)
                )
                Text(
                    text = "Get Your Groceries In As Fast As One Hour",
                    color = Color.White,
                    fontFamily = gilroyFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                )
                // Get Started Button
                CustomButton(
                    text = "Get Started",
                    buttonColor = colorResource(id = R.color.primaryColor),
                    onClick = {
                        // Navigate to the LoginScreen
                        navController.navigate(ScreenRoot.LoginScreen.router) {
                            // Clear the back stack or pop up to specific destinations
                            popUpTo(ScreenRoot.OnboardingScreen.router) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}

// Preview with NavController
@Preview
@Composable
fun OnboardingScreenPrev() {
    // Create a dummy NavController for preview purposes
    OnboardingScreen(navController = rememberNavController())
}
