package com.ingeacev.mymeliaplication.commons.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.ingeacev.mymeliaplication.commons.utils.border_radius_xs
import com.ingeacev.mymeliaplication.commons.utils.font_size_20
import com.ingeacev.mymeliaplication.commons.utils.spacing_lg
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxs

/**
 * Created by Alejandro Acevedo on 09,febrero,2025
 */

@Composable
fun SimpleButton(
    modifier: Modifier = Modifier
        .padding(top = spacing_lg)
        .fillMaxWidth(0.8f),
    isEnable: Boolean,
    buttonColor: ButtonColors = ButtonDefaults.buttonColors(),
    buttonText: String,
    buttonBorder: BorderStroke? = null,
    buttonShape: Shape = RoundedCornerShape(border_radius_xs),
    buttonTextSize: TextUnit = font_size_20,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier,
        shape = buttonShape,
        border = buttonBorder,
        contentPadding = PaddingValues(spacing_xxs),
        enabled = isEnable,
        colors = buttonColor,
    ) {
        Text(
            text = buttonText,
            fontSize = buttonTextSize,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
@Preview
fun SimpleButtonPreview() {
    SimpleButton(
        isEnable = true,
        onClick = { },
        buttonText = "Simple button"
    )
}