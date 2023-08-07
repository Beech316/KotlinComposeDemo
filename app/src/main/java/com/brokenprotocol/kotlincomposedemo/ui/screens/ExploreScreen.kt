package com.brokenprotocol.kotlincomposedemo.ui.screens

import android.text.style.AlignmentSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    modifier : Modifier = Modifier,
    onCategoryelected: (Category) -> Unit = {}
) {
    val dimens = LocalDimension.current
    val list = DataManager.getCategoryList()

    Column() {

        Text(
            text = stringResource(id = R.string.categories_header_title),
            modifier = Modifier.padding(horizontal = dimens.medium, vertical = dimens.small),
            fontSize = dimens.exploreSectionHeader
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = dimens.small, vertical = dimens.none),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
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
                        )
                        .selectable(
                            selected = false,
                            onClick = {
                                onCategoryelected(list[it])
                            }
                        )
                )
            }
        }

        Text(
            text = stringResource(id = R.string.details_header_title),
            modifier = Modifier.padding(horizontal = dimens.medium, vertical = dimens.small),
            fontSize = dimens.exploreSectionHeader
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = dimens.small, vertical = dimens.none),
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
        ) {
            items(
                list.size,
                key = { list[it].id },
            ) {
                DetailListItem(
                    category = list[it],
                    modifier = Modifier
                        .padding(
                            all = dimens.small
                        )
                        .selectable(
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

@Composable
fun DetailListItem(
    category: Category,
    modifier : Modifier = Modifier)
{
    val dimens = LocalDimension.current

    Card(
        elevation = dimens.extraSmall,
        shape = RoundedCornerShape(dimens.medium),
        modifier = modifier
            .height(200.dp)
            .width(240.dp)
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f)
                    .align(Alignment.BottomCenter)
            ) {
                Surface(
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f)
                ) {}

                Text(
                    text = category.name,
                    color = Color.White,
                    fontSize = dimens.categoryItemTitle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}