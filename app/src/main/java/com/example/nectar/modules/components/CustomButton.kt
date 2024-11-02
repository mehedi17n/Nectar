package com.example.nectar.modules.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nectar.R
import com.example.nectar.ui.theme.gilroyFontFamily

@Composable
fun CustomButton(
    text: String,
    buttonColor: Color,
    onClick: () -> Unit,
    iconPainter: Painter? = null // Optional icon parameter
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            // Show icon on the far left if provided
            if (iconPainter != null) {
                Image(
                    painter = iconPainter,
                    contentDescription = null, // decorative icon
                    modifier = Modifier
                        .size(24.dp) // Set the icon size
                        .weight(0.1f) // Push the icon to the left
                )
            }

            // Text should stay centered
            Text(
                text = text,
                fontFamily = gilroyFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                modifier = Modifier
                    .weight(0.8f), // Use weight to center the text
                textAlign = TextAlign.Center
            )

            // Optional empty space on the right if needed for padding
            Spacer(modifier = Modifier.weight(0.1f))
        }
    }
}
