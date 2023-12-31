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
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.DataManager
import com.brokenprotocol.kotlincomposedemo.data.models.Detail
import com.brokenprotocol.kotlincomposedemo.ui.cells.DetailListItem
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun DetailListScreen(
    detailList : List<Detail>,
    modifier : Modifier = Modifier,
    onDetailSelected : (Detail) -> Unit = {}
) {
    val dimens = LocalDimension.current

    LazyColumn(
        contentPadding = PaddingValues(horizontal = dimens.small, vertical = dimens.small),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
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