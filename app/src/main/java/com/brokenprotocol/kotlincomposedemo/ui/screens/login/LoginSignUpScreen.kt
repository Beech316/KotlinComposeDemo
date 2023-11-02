package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun LoginSignUpScreen(
    modifier : Modifier = Modifier,
) {

    var usernameText by remember { mutableStateOf("") }
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var confirmPasswordText by remember { mutableStateOf("") }

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
                value = usernameText,
                onValueChange = { usernameText = it },
                label = { Text(text = "Username") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            OutlinedTextField(
                value = emailText,
                onValueChange = { emailText = it },
                label = { Text(text = "Email") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                label = { Text(text = "Password") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            OutlinedTextField(
                value = confirmPasswordText,
                onValueChange = { confirmPasswordText = it },
                label = { Text(text = "Confirm Password") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(dimens.loginButtonHeight)
                    .width(dimens.loginButtonWidth)
                    .padding(vertical = dimens.medium),
                shape = RoundedCornerShape(20f),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(
                    text = stringResource(id = R.string.login_button),
                    fontSize = dimens.loginButtonTitle
                )
            }

        }

        Spacer(modifier = Modifier.weight(1.0f))

    }
}