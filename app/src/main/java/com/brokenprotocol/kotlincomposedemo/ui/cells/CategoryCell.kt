package com.brokenprotocol.kotlincomposedemo.ui.cells

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.models.Category
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun CategoryListItem(
    category: Category,
    modifier : Modifier = Modifier
)
{
    val dimens = LocalDimension.current

    Card(
        elevation = dimens.extraSmall,
        shape = RoundedCornerShape(dimens.medium),
        modifier = modifier
            .height(150.dp)
            .width(150.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            if (category.imageUrlString.isNotEmpty()) {
                AsyncImage(
                    model = category.imageUrlString,
                    contentDescription = "Category image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.category_image),
                    contentDescription = "Default Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Text(
                text = category.name,
                color = Color.White,
                fontSize = dimens.categoryItemTitle,
                textAlign = TextAlign.Center
            )
        }
    }
}