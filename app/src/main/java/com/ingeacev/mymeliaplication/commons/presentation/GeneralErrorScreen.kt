package com.ingeacev.mymeliaplication.commons.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ingeacev.mymeliaplication.commons.utils.font_size_20
import com.ingeacev.mymeliaplication.commons.utils.font_size_24
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxs
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxxs

/**
 * Created by Alejandro Acevedo on 09,febrero,2025
 */

@Composable
fun GeneralErrorScreen(
    errorTitle: String,
    errorSubTitle: String = "",
    onActionButtonClick: () -> Unit,
    actionButtonText: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            errorTitle,
            Modifier.padding(spacing_xxs),
            fontSize = font_size_24,
        )
        if (errorSubTitle.isNotEmpty()) {
            Text(
                errorSubTitle,
                Modifier.padding(spacing_xxxs),
                fontSize = font_size_20,
            )
        }
        Spacer(modifier = Modifier.padding(spacing_xxs))
        SimpleButton(
            isEnable = true,
            onClick = { onActionButtonClick() },
            buttonText = actionButtonText
        )
    }
}

@Preview
@Composable
fun GeneralErrorScreenPreview() {
    GeneralErrorScreen(
        errorTitle = "Algo ha salido mal",
        errorSubTitle = "Por favor vuelve a intentarlo",
        onActionButtonClick = {},
        actionButtonText = "Reintentar"
    )
}