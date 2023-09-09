package com.brokenprotocol.kotlincomposedemo.data.models

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

data class KotlinComposeDemoFont(
    val family : FontFamily,
    val size : TextUnit,
    val style : FontStyle,
    val weight : FontWeight
)
