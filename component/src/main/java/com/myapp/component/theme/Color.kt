package com.myapp.component.theme

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Green500 = Color(0xFF1EB980)
val DarkBlue900 = Color(0xFF26282F)
val Yellow700 = Color(0xFFFBC02D)
val Gray700 = Color(0xFF616161)
val LightBlue700 = Color(0xFF0288D1)
val Indigo700 = Color(0xFF303F9F)

val gstColor = Gray700
val gmtColor = Yellow700
val solanaColor = Indigo700
val usdcColor = LightBlue700


// Rally is always dark themed.
val ColorPalette = darkColors(
    primary = Green500,
    surface = DarkBlue900,
    onSurface = Color.White,
    background = DarkBlue900,
    onBackground = Color.White
)