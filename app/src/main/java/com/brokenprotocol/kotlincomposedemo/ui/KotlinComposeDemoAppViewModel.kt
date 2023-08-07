package com.brokenprotocol.kotlincomposedemo.ui

import androidx.lifecycle.ViewModel
import com.brokenprotocol.kotlincomposedemo.data.KotlinComposeDemoAppUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class KotlinComposeDemoAppViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(KotlinComposeDemoAppUiState(demo = 0))
    val uiState: StateFlow<KotlinComposeDemoAppUiState> = _uiState.asStateFlow()

}