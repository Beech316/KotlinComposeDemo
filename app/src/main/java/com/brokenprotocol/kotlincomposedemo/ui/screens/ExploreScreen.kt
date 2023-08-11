package com.brokenprotocol.kotlincomposedemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    modifier : Modifier = Modifier,
    onCategorySelected : (Category) -> Unit = {},
    onDetailSelected : (Detail) -> Unit = {}
) {
    val dimens = LocalDimension.current
    val categoryList = DataManager.getCategoryList()

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

        val detailList = DataManager.getDetailList()

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