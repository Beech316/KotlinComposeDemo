package com.brokenprotocol.kotlincomposedemo.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.brokenprotocol.kotlincomposedemo.data.DataManager
import com.brokenprotocol.kotlincomposedemo.ui.cells.DetailListItem
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun DetailListScreen(
    modifier : Modifier = Modifier
) {
    val dimens = LocalDimension.current
    val list = DataManager.getCategoryList()

    LazyColumn(
        contentPadding = PaddingValues(horizontal = dimens.small, vertical = dimens.small),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
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