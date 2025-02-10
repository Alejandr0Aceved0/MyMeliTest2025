package com.ingeacev.mymeliaplication.commons.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ingeacev.mymeliaplication.commons.utils.spacing_md
import com.ingeacev.mymeliaplication.commons.utils.spacing_sm
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxs

/**
 * Created by Alejandro Acevedo on 09,febrero,2025
 */

@Composable
fun ModalSnackbar(
    message: String,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable { onDismiss() },
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(spacing_sm),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.elevatedCardElevation(spacing_xxs),
            modifier = Modifier
                .padding(spacing_md)
                .fillMaxWidth(0.9f)
        ) {
            Column(
                modifier = Modifier.padding(spacing_sm),
                verticalArrangement = Arrangement.spacedBy(spacing_xxs),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    if (actionLabel != null && onActionClick != null) {
                        TextButton(onClick = {
                            onActionClick()
                            onDismiss()
                        }) {
                            Text(text = actionLabel.uppercase())
                        }
                    }
                    TextButton(onClick = onDismiss) {
                        Text(text = "CERRAR")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewModalSnackbar() {
    MaterialTheme {
        ModalSnackbar(
            message = "Ah ocurrido un error",
            actionLabel = "Aceptar",
            onActionClick = {},
            onDismiss = {}
        )
    }
}
