package com.brokenprotocol.kotlincomposedemo.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brokenprotocol.kotlincomposedemo.R
import com.brokenprotocol.kotlincomposedemo.data.StyleManager
import com.brokenprotocol.kotlincomposedemo.ui.theme.LocalDimension
import com.composeuisuite.ohteepee.OhTeePeeInput
import com.composeuisuite.ohteepee.configuration.OhTeePeeCellConfiguration
import com.composeuisuite.ohteepee.configuration.OhTeePeeConfigurations

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

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            val headerTextStyle = StyleManager.loginHeader()
            Text(
                text = stringResource(id = R.string.login_passcode_text),
                modifier = Modifier
                    .padding(dimens.small),
                style = headerTextStyle,
                textAlign = TextAlign.Center
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1.0f))
            OtpInput()
            Spacer(modifier = Modifier.weight(1.0f))
        }

        Spacer(modifier = Modifier.weight(1.0f))
    }
}

@Composable
fun OtpInput() {

    // a mutable state to handle OTP value changes…
    var otpValue: String by remember { mutableStateOf("") }

    // this config will be used for each cell
    val defaultCellConfig = OhTeePeeCellConfiguration.withDefaults(
        borderColor = Color.LightGray,
        borderWidth = 1.dp,
        shape = RoundedCornerShape(16.dp),
        textStyle = TextStyle(
            color = Color.Black
        )
    )

    OhTeePeeInput(
        value = otpValue,
        onValueChange = { newValue, isValid ->
            otpValue = newValue
        },
        configurations = OhTeePeeConfigurations.withDefaults(
            cellsCount = 6,
            emptyCellConfig = defaultCellConfig,
            cellModifier = Modifier
                .padding(horizontal = 4.dp)
                .size(48.dp),
            filledCellConfig = defaultCellConfig,
            activeCellConfig = defaultCellConfig.copy(
                borderColor = Color.Blue,
                borderWidth = 2.dp
            ),
            errorCellConfig = defaultCellConfig.copy(
                borderColor = Color.Red,
                borderWidth = 2.dp
            ),
            placeHolder = "-",
        ),
    )
}