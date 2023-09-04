package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension
import java.util.Locale

@Composable
fun LoginSplashScreen(
    modifier : Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        val dimens = LocalDimension.current
        val context = LocalContext.current

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimens.medium),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(text = "Apple")
        }

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimens.medium),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        ) {
            Text(text = "Google")
        }

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimens.medium),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = "Facebook")
        }

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimens.medium),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color.Yellow)
        ) {
            Text(text = "X / Twitter")
        }

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = dimens.medium),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        ) {
            Text(text = "Github")
        }

    }
}