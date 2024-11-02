package com.example.nectar.modules.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.gilroyFontFamily

@Composable
fun CustomButton(
    text: String,
    buttonColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor, // Use the dynamic color passed as a parameter
            contentColor = Color.White // Set the text color for the button
        ),
        shape = RoundedCornerShape(19.dp),
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .height(64.dp)
    ) {
        Text(
            text = text,
            fontFamily = gilroyFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
    }
}