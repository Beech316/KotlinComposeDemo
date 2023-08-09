package com.brokenprotocol.kotlincomposedemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.brokenprotocol.kotlincomposedemo.R

@Composable
fun LoadImageOrDefault(
    imageUrl : String,
    default : Int,
    modifier : Modifier = Modifier
) {
    if (imageUrl.isNotEmpty()) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Category image",
            contentScale = ContentScale.FillBounds,
            modifier = modifier
        )
    } else {
        Image(
            painter = painterResource(id = default),
            contentDescription = "Default Image",
            contentScale = ContentScale.FillBounds,
            modifier = modifier
        )
    }
}