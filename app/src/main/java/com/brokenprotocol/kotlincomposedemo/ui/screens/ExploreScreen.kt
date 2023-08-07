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
import com.brokenprotocol.kotlincomposedemo.ui.cells.CategoryListItem
import com.brokenprotocol.kotlincomposedemo.ui.cells.DetailListItem
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