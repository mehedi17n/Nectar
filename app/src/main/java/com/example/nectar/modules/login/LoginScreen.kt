package com.example.nectar.modules.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nectar.R
import com.example.nectar.modules.components.CustomButton
import com.example.nectar.ui.theme.gilroyFontFamily
import androidx.compose.runtime.*
import androidx.compose.ui.focus.focusRequester
import com.example.nectar.modules.navigation.ScreenRoot
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Text next to the icon
        Text(
            text = buildAnnotatedString {
                append("Get Your Groceries\nWith ")
                withStyle(style = SpanStyle(color = colorResource(id = R.color.primaryColor))) {
                    append("Nectar")
                }
            },
            color = Color.Black,
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 26.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Start, // Align the text to the left
            modifier = Modifier
                .fillMaxWidth() // Ensure it takes up the full width
                .padding(start = 30.dp, top = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // State to hold the input value
        var inputText by remember { mutableStateOf("") }

        // Focus state for the input field
        var isFocused by remember { mutableStateOf(false) }

        // TextField for phone number input with Bangladesh flag icon and +880 prefix
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(0.85f).padding(start = 2.dp)
        ) {
            // Bangladesh flag icon
            Image(
                painter = painterResource(id = R.drawable.ic_bangladesh_flag),
                contentDescription = "Bangladesh Flag",
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            // +880 prefix Text
            Text(
                text = "+880",
                fontSize = 18.sp,
                letterSpacing = 2.sp,
            )

            var text = remember { mutableStateOf("") }

            val change: (String) -> Unit = { input ->
                if (input.length <= 10 && (input.length != 2 || input[0] == '1')) {
                    text.value = input
                }
            }

            TextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                        // Navigate to the next page when focused
                        if (isFocused) {
                            navController.navigate(ScreenRoot.PhoneLoginScreen.router) {
                                // Clear the back stack or pop up to specific destinations
                            popUpTo(ScreenRoot.LoginScreen.router) { inclusive = false }
                    }
                }
            },
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 18.sp,
                    letterSpacing = 2.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        // Bottom line
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(start = 0.dp)
                .height(1.dp)
                .background(Color.Gray)
        )

        // Spacer between TextField and below Text
        Spacer(modifier = Modifier.height(40.dp))

        // Additional Text below the TextField
        Text(
            text = "Or connect with social media",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )

        // Spacer between the text and buttons
        Spacer(modifier = Modifier.height(40.dp))

        // Two custom buttons below the text
        CustomButton(
            text = "Continue with Google",
            onClick = {
                // Handle login action
            },
            buttonColor = colorResource(id = R.color.google_btn_color),
            iconPainter = painterResource(id = R.drawable.ic_google)
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomButton(
            text = "Continue with Facebook",
            onClick = {
                // Handle cancel action
            },
            buttonColor = colorResource(id = R.color.facebook_btn_color),
            iconPainter = painterResource(id = R.drawable.ic_fb)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_nectar_logo_colored),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 15.dp, end = 48.dp)
        )
    }
}

