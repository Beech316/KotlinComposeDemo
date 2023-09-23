package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.FontManager
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun LoginSplashScreen(
    modifier : Modifier = Modifier,
    onEmailSelected : () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        val dimens = LocalDimension.current
        val context = LocalContext.current

        val headerFont = FontManager.loginHeader()
        Text(
            text = stringResource(id = R.string.login_splash_text),
            modifier = Modifier
                .padding(
                    start = dimens.medium,
                    top = dimens.medium,
                    end = dimens.medium,
                    bottom = dimens.small
                )
                .align(Alignment.CenterHorizontally),
            fontFamily = headerFont.family,
            fontSize = headerFont.size,
            fontStyle = headerFont.style,
            fontWeight = headerFont.weight
        )
        
        Column(
            modifier = Modifier
                .padding(
                    start = dimens.none,
                    top = dimens.none,
                    end = dimens.none,
                    bottom = dimens.small
                )
                .fillMaxWidth()
        ) {

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.White),
                onClick = {

                }
            ) {
                Text(text = "Apple", color = Color.White, fontSize = dimens.loginButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.LightGray),
                onClick = {

                }
            ) {
                Text(text = "Google", color = Color.LightGray, fontSize = dimens.loginButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.Blue),
                onClick = {

                }
            ) {
                Text(text = "Facebook", color = Color.Blue, fontSize = dimens.loginButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.Yellow),
                onClick = {

                }
            ) {
                Text(text = "X / Twitter", color = Color.Yellow, fontSize = dimens.loginButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.Magenta),
                onClick = {

                }
            ) {
                Text(text = "Github", color = Color.Magenta, fontSize = dimens.loginButtonTitle)
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(
                    start = dimens.large,
                    top = dimens.small,
                    end = dimens.large,
                    bottom = dimens.none
                )
                .background(Color.White),
            thickness = dimens.extraExtraSmall
        )

        Column(
            modifier = Modifier
                .padding(top = dimens.small)
                .fillMaxWidth()
        ) {

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.White),
                onClick = {
                    onEmailSelected()
                }
            ) {
                Text(text = "Email", color = Color.White, fontSize = dimens.loginButtonTitle)
            }

        }

    }
}