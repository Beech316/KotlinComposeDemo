package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.brokenprotocol.kotlincomposedemo.data.FontManager
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension

@Composable
fun LoginSplashScreen(
    modifier : Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {

        val dimens = LocalDimension.current
        val context = LocalContext.current

        val headerFont = FontManager.loginHeader()
        Text(
            text = "Sign in or create an account",
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
            Button(
                modifier = Modifier
                    .padding(top = dimens.small)
                    .align(Alignment.CenterHorizontally)
                    .width(dimens.extraExtraLarge),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(text = "Apple")
            }

            Button(
                modifier = Modifier
                    .padding(top = dimens.small)
                    .align(Alignment.CenterHorizontally)
                    .width(dimens.extraExtraLarge),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Text(text = "Google")
            }

            Button(
                modifier = Modifier
                    .padding(top = dimens.small)
                    .align(Alignment.CenterHorizontally)
                    .width(dimens.extraExtraLarge),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(text = "Facebook")
            }

            Button(
                modifier = Modifier
                    .padding(top = dimens.small)
                    .align(Alignment.CenterHorizontally)
                    .width(dimens.extraExtraLarge),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(Color.Yellow)
            ) {
                Text(text = "X / Twitter")
            }

            Button(
                modifier = Modifier
                    .padding(top = dimens.small)
                    .align(Alignment.CenterHorizontally)
                    .width(dimens.extraExtraLarge),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(Color.Magenta)
            ) {
                Text(text = "Github")
            }
        }

        Divider(
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
            Button(
                modifier = Modifier
                    .padding(top = dimens.small)
                    .align(Alignment.CenterHorizontally)
                    .width(dimens.extraExtraLarge),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(text = "Email")
            }

        }

    }
}