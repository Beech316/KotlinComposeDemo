package com.brokenprotocol.kotlincomposedemo.ui.screens

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.models.Detail
import com.brokenprotocol.kotlincomposedemo.ui.components.LoadImageOrDefault
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    detail : Detail,
    liked : Boolean,
    modifier : Modifier = Modifier,
    onLikeSelected : () -> Unit = {}
) {
    val dimens = LocalDimension.current
    val context = LocalContext.current
    val images = detail.getImages()

    val pagerState = rememberPagerState { images.size }

    val sendIntent : Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "Look at this awesome ${detail.name} I found on KotlinDemoApp!")
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)

    Column() {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.height(200.dp)
        ) {
            LoadImageOrDefault(
                imageUrl = images[it],
                default = R.drawable.detail_image
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
        ) {
            IconButton(
                onClick = {
                    context.startActivity(shareIntent)
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = null
                )
            }

            Text(
                text = detail.name,
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )

            IconButton(
                onClick = { onLikeSelected() }
            ) {
                if (liked) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = null
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null
                    )
                }
            }
        }

        Text(
            text = detail.desc,
            modifier = Modifier.padding(dimens.small)
        )

    }

}