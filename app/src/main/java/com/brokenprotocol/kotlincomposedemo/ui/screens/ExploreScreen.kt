package com.brokenprotocol.kotlincomposedemo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
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
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.DataManager
import com.brokenprotocol.kotlincomposedemo.data.models.Category
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun ExploreScreen(
    modifier : Modifier = Modifier
) {
    val dimens = LocalDimension.current
    val list = DataManager.getCategoryList()

    Column() {
        Text(text = "Categories")
        LazyRow(
            contentPadding = PaddingValues(horizontal = dimens.small, vertical = dimens.small)
        ) {
            items(
                list.size,
                key = { list[it].id },
            ) {
                CategoryListItem(
                    category = list[it],
                    modifier = Modifier
                        .padding(
                            all = dimens.small
                        ).selectable(
                            selected = false,
                            onClick = {

                            }
                        )
                )
            }
        }
    }


}

@Composable
fun CategoryListItem(
    category: Category,
    modifier : Modifier = Modifier)
{
    val dimens = LocalDimension.current

    Card(
        elevation = dimens.extraSmall,
        shape = RoundedCornerShape(dimens.medium),
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ){

            if (category.imageUrlString.isNotEmpty()) {
                AsyncImage(
                    model = category.imageUrlString,
                    contentDescription = "Category image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .align(Alignment.Center)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.category_image),
                    contentDescription = "Default Image")
            }

            Text(
                text = category.name,
                color = Color.White,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}