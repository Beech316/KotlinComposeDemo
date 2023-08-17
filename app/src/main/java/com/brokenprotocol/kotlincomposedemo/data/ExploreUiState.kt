package com.brokenprotocol.kotlincomposedemo.data

import com.brokenprotocol.kotlincomposedemo.data.models.Category
import com.brokenprotocol.kotlincomposedemo.data.models.Detail

data class ExploreUiState(
    var selectedCategory : Category?,
    var selectedDetail : Detail?,
    var categoryList : List<Category> = listOf(),
    var detailList : List<Detail> = listOf()
)