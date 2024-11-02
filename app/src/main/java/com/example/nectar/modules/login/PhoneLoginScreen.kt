@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nectar.modules.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nectar.R
import com.example.nectar.modules.components.CustomButton
import com.example.nectar.modules.components.CustomNumberInputButton
import com.example.nectar.ui.theme.gilroyFontFamily
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneLoginScreen(navController: NavController) {
    // Create a FocusRequester instance
    val focusRequester = remember { FocusRequester() }
    val localFocusManager = LocalFocusManager.current

    // Background Image with blur at the top
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                onClick = {
                    localFocusManager.clearFocus() // Close keyboard on tap outside
                },
                indication = null, // Disable ripple effect
                interactionSource = remember { MutableInteractionSource() } // Required when indication is null
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_bg_blur),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        // Content on top of the blurred background
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 46.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Back Icon on the top left
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                contentDescription = "Back Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(36.dp)
                    .padding(8.dp)
                    .clip(CircleShape)
                    .clickable { navController.popBackStack() }
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Text next to the icon
            Text(
                text = buildAnnotatedString {
                    append("Enter Your ")
                    withStyle(style = SpanStyle(color = colorResource(id = R.color.primaryColor))) {
                        append("Mobile ")
                    }
                    append("Number")
                },
                color = Color.Black,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 26.sp,
                lineHeight = 40.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, top = 10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // TextField for phone number input with Bangladesh flag icon and +880 prefix
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.85f).padding(start = 32.dp)
            ) {
                // Bangladesh flag icon
                Image(
                    painter = painterResource(id = R.drawable.ic_bangladesh_flag),
                    contentDescription = "Bangladesh Flag",
                    modifier = Modifier.size(24.dp)
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

                // Auto-focus on the TextField when the screen loads
                LaunchedEffect(Unit) {
                    delay(300) // Add a slight delay to ensure everything is rendered
                    focusRequester.requestFocus()
                }

                TextField(
                    value = text.value,
                    onValueChange = change,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester), // Attach the focusRequester to the TextField
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontSize = 18.sp,
                        letterSpacing = 2.sp
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
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
                    .fillMaxWidth(0.89f)
                    .padding(start = 30.dp)
                    .height(1.dp)
                    .background(Color.Gray)
            )
        }

        // Floating action button at the bottom right corner
        Box(
            modifier = Modifier
                .imePadding()
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            androidx.compose.material3.FloatingActionButton(
                onClick = {

                },
                containerColor = colorResource(id = R.color.primaryColor),
                modifier = Modifier
                    .padding(bottom = 70.dp, end = 20.dp)
                    .size(56.dp),
                shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_next),
                    contentDescription = "Next Icon",
                    tint = Color.White, // Icon color
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}