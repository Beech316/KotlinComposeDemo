package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.StyleManager
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension
import com.google.common.io.Resources.getResource

@Composable
fun LoginEmailScreen(
    modifier : Modifier = Modifier,
    onSignUpSelected : () -> Unit = {}
) {

    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        val dimens = LocalDimension.current

        Spacer(modifier = Modifier.weight(1.0f))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            val headerTextStyle = StyleManager.loginHeader()
            Text(
                text = stringResource(id = R.string.login_email_text),
                modifier = Modifier
                    .padding(dimens.small),
                style = headerTextStyle,
                textAlign = TextAlign.Center
            )
        }

        Column(modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
        ) {

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

            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(dimens.loginButtonHeight)
                    .width(dimens.loginButtonWidth)
                    .padding(vertical = dimens.medium),
                shape = RoundedCornerShape(20f),
                onClick = {
                    onSignUpSelected()
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = stringResource(id = R.string.login_button), fontSize = dimens.loginButtonTitle)
            }

        }

        Spacer(modifier = Modifier.weight(1.0f))

        val annotatedString = buildAnnotatedString {
            append("By joining, you agree to the ")

            pushStringAnnotation(tag = "policy", annotation = "https://google.com/policy")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("privacy policy")
            }
            pop()

            append(" and ")

            pushStringAnnotation(tag = "terms", annotation = "https://google.com/terms")

            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("terms of use")
            }

            pop()
        }

        ClickableText(
            text = annotatedString,
            modifier = Modifier.padding(dimens.small),
            style = StyleManager.createAccountLink(),
            onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "policy", start = offset, end = offset).firstOrNull()?.let {
                    Log.d("policy URL", it.item)
                }

                annotatedString.getStringAnnotations(tag = "terms", start = offset, end = offset).firstOrNull()?.let {
                    Log.d("terms URL", it.item)
                }

        })



    }

}