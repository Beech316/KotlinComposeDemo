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
import com.brokenprotocol.kotlincomposedemo.data.StyleManager
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

        val headerTextStyle = StyleManager.loginHeader()
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
            style = headerTextStyle
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
                    .height(dimens.loginCategoryButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.White),
                onClick = {

                }
            ) {
                Text(text = stringResource(id = R.string.login_apple_button), color = Color.White, fontSize = dimens.loginCategoryButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginCategoryButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.LightGray),
                onClick = {

                }
            ) {
                Text(text = stringResource(id = R.string.login_google_button), color = Color.LightGray, fontSize = dimens.loginCategoryButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginCategoryButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.Blue),
                onClick = {

                }
            ) {
                Text(text = stringResource(id = R.string.login_facebook_button), color = Color.Blue, fontSize = dimens.loginCategoryButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginCategoryButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.Yellow),
                onClick = {

                }
            ) {
                Text(text = stringResource(id = R.string.login_twitter_button), color = Color.Yellow, fontSize = dimens.loginCategoryButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.6f)
                    .height(dimens.loginCategoryButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.Magenta),
                onClick = {

                }
            ) {
                Text(text = stringResource(id = R.string.login_github_button), color = Color.Magenta, fontSize = dimens.loginCategoryButtonTitle)
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
                    .height(dimens.loginCategoryButtonHeight)
                    .padding(vertical = dimens.medium),
                border = BorderStroke(dimens.extraExtraSmall, Color.White),
                onClick = {
                    onEmailSelected()
                }
            ) {
                Text(text = stringResource(id = R.string.login_email_button), color = Color.White, fontSize = dimens.loginCategoryButtonTitle)
            }

        }

    }
}