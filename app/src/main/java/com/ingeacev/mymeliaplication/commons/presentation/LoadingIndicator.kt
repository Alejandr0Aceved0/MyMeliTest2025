package com.ingeacev.mymeliaplication.commons.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */
@Composable
fun LoadingIndicator(
    circularIndicatorColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC107)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = circularIndicatorColor,
            modifier = Modifier.fillMaxSize(0.1f),
        )
    }
}