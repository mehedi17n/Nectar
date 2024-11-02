package com.example.nectar.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nectar.R

val gilroyFontFamily = FontFamily(
    Font(R.font.gilroy_black, FontWeight.Black),
    Font(R.font.gilroy_bold, FontWeight.Bold),
    Font(R.font.gilroy_extra_bold, FontWeight.ExtraBold),
    Font(R.font.gilroy_regular, FontWeight.Normal),
    Font(R.font.gilroy_thin, FontWeight.Thin),
    Font(R.font.gilroy_light, FontWeight.Light),
    Font(R.font.gilroy_ultra_light, FontWeight.ExtraLight),
    Font(R.font.gilroy_semi_bold, FontWeight.SemiBold),
    Font(R.font.gilroy_medium, FontWeight.Medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 48.sp,
        lineHeight = 29.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 26.sp
    ),

    bodySmall = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),

    labelLarge = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp,
    ),

    labelMedium = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 15.sp,
    ),

    labelSmall = TextStyle(
        fontFamily = gilroyFontFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 14.sp,
    )


)