package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoginEmailScreen(
    modifier : Modifier = Modifier,
) {
    Box(modifier = Modifier.height(100.dp).width(100.dp).background(Color.Red))
}