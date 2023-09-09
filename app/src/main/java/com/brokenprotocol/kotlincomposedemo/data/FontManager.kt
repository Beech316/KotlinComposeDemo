package com.brokenprotocol.kotlincomposedemo.data

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.brokenprotocol.kotlincomposedemo.data.models.KotlinComposeDemoFont

object FontManager {

    fun loginHeader(): KotlinComposeDemoFont {

        return KotlinComposeDemoFont(
            family = FontFamily.Monospace,
            size = 18.sp,
            style = FontStyle.Normal,
            weight = FontWeight(weight = 1)
        )

    }

}