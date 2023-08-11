package com.brokenprotocol.kotlincomposedemo.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.models.Detail
import com.brokenprotocol.kotlincomposedemo.ui.components.LoadImageOrDefault

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    detail : Detail,
    modifier : Modifier = Modifier
) {

    val images = detail.getImages()

    val pagerState = rememberPagerState { images.size }

    Column() {
        HorizontalPager(state = pagerState) {
            LoadImageOrDefault(
                imageUrl = images[it],
                default = R.drawable.detail_image
            )
        }

        Text(text = detail.name)
    }
    
}