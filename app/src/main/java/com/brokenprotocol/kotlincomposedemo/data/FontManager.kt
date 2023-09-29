package com.brokenprotocol.kotlincomposedemo.data

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object FontManager {

//    TextStyle(
//        color = Color.Red,
//        fontSize = 16.sp,
//        fontFamily = FontFamily.Serif,
//        fontWeight = FontWeight.W800,
//        fontStyle = FontStyle.Italic,
//        letterSpacing = 0.5.em,
//        background = Color.LightGray,
//        textDecoration = TextDecoration.Underline
//    )

    fun loginHeader(): TextStyle {

        return TextStyle(
            fontSize = 22.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight(weight = 2),
            fontStyle = FontStyle.Normal
        )

    }

}