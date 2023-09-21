package com.brokenprotocol.kotlincomposedemo.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Future upgrade: https://proandroiddev.com/supporting-different-screen-sizes-on-android-with-jetpack-compose-f215c13081bd

val LocalDimension = compositionLocalOf { Dimensions() }

data class Dimensions (

    // standard dp units

    val default : Dp = 8.dp,
    val none : Dp = 0.dp,
    val extraExtraSmall : Dp = 2.dp,
    val extraSmall : Dp = 4.dp,
    val small : Dp = 8.dp,
    val medium : Dp = 16.dp,
    val large : Dp = 32.dp,
    val extraLarge : Dp = 64.dp,
    val extraExtraLarge : Dp = 128.dp,

    // exceptional dp units

    val loginButtonHeight : Dp = 86.dp,

    // Text Units

    val exploreSectionHeader : TextUnit = 32.sp,

    val categoryItemTitle : TextUnit = 24.sp,

    val loginButtonTitle : TextUnit = 20.sp
)
