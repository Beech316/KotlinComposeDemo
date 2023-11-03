package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun LoginPasscodeScreen(
    modifier : Modifier = Modifier,
    onCodeConfirmed : () -> Unit = {}
) {

    var passcodeText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        val dimens = LocalDimension.current

        Spacer(modifier = Modifier.weight(1.0f))

        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            OutlinedTextField(
                value = passcodeText,
                onValueChange = { passcodeText = it },
                label = { Text(text = "Username") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.weight(1.0f))
    }
}