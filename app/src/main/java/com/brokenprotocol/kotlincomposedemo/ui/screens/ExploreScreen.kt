package com.brokenprotocol.kotlincomposedemo.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.DataManager
import com.brokenprotocol.kotlincomposedemo.data.models.Category
import com.brokenprotocol.kotlincomposedemo.data.models.Detail
import com.brokenprotocol.kotlincomposedemo.ui.cells.CategoryListItem
import com.brokenprotocol.kotlincomposedemo.ui.cells.DetailListItem
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun ExploreScreen(
    categoryList : List<Category>,
    detailList : List<Detail>,
    modifier : Modifier = Modifier,
    onCategorySelected : (Category) -> Unit = {},
    onDetailSelected : (Detail) -> Unit = {}
) {
    val dimens = LocalDimension.current

    Column() {

        Log.i("Explore Background", "" + MaterialTheme.colorScheme.background)

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
                categoryList.size,
                key = { categoryList[it].id },
            ) {
                CategoryListItem(
                    category = categoryList[it],
                    modifier = Modifier
                        .padding(
                            all = dimens.small
                        )
                        .selectable(
                            selected = false,
                            onClick = {
                                onCategorySelected(categoryList[it])
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
                detailList.size,
                key = { detailList[it].id },
            ) {
                DetailListItem(
                    detail = detailList[it],
                    defaultImage = R.drawable.detail_image,
                    modifier = Modifier
                        .padding(
                            all = dimens.small
                        )
                        .selectable(
                            selected = false,
                            onClick = {
                                onDetailSelected(detailList[it])
                            }
                        )
                )
            }
        }
    }
}