package com.example.nectar.modules.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.gilroyFontFamily

@Composable
fun CustomNumberInputButton(
    onClick: () -> Unit,
    icon: Painter,
    buttonText: String = "+880"
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent, // Transparent background
            contentColor = Color.Black // Set the content color (text and icon color)
        ),
        shape = RoundedCornerShape(19.dp),
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .height(64.dp)
            .border(1.dp, Color.Transparent)
    ) {
        // Row to align the icon and text horizontally
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // Icon on the left side
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text

            // Text next to the icon
            Text(
                text = buttonText,
                fontSize = 18.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Normal
            )

            // Spacer to push the content to the left and keep the right side empty
            Spacer(modifier = Modifier.weight(1f))
        }
    }

    // Bottom line
    Box(
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .height(1.dp)
            .background(Color.Gray) // Customize the color of the bottom line
    )
}