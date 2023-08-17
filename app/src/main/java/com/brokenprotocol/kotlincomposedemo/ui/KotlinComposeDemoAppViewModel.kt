package com.brokenprotocol.kotlincomposedemo.ui

import androidx.lifecycle.ViewModel
import com.brokenprotocol.kotlincomposedemo.data.DataManager
import com.brokenprotocol.kotlincomposedemo.data.ExploreUiState
import com.brokenprotocol.kotlincomposedemo.data.models.Category
import com.brokenprotocol.kotlincomposedemo.data.models.Detail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class KotlinComposeDemoAppViewModel : ViewModel() {

    private val _exploreUiState = MutableStateFlow(ExploreUiState(
        selectedCategory = null,
        selectedDetail = null
    ))

    val exploreUiState : StateFlow<ExploreUiState> = _exploreUiState.asStateFlow()

    init {
        updateCategoryList(DataManager.getCategoryList())
        updateDetailList(DataManager.getDetailList())
    }

    fun updateCategoryList(list : List<Category>) {
        _exploreUiState.update { currentState ->
            currentState.copy(
                categoryList = list
            )
        }
    }

    fun updateDetailList(list : List<Detail>) {
        _exploreUiState.update { currentState ->
            currentState.copy(
                detailList = list
            )
        }
    }

    fun updateSelectedDetail(detail : Detail) {
        _exploreUiState.update { currentState ->
            currentState.copy(
                selectedDetail = detail
            )
        }
    }

}