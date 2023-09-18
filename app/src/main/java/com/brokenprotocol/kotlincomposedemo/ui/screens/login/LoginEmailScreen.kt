package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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

@Composable
fun LoginEmailScreen(
    modifier : Modifier = Modifier,
) {

    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.weight(1.0f))

        Column(modifier = modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
            .wrapContentHeight()
        ) {

            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                label = { Text(text = "Email") }
            )

            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                label = { Text(text = "Password") }
            )

        }

        Spacer(modifier = Modifier.weight(1.0f))

    }

}