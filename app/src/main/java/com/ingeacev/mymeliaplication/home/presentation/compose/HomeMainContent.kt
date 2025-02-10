package com.ingeacev.mymeliaplication.home.presentation.compose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ingeacev.mymeliaplication.commons.presentation.ModalSnackbar
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxxs
import com.ingeacev.mymeliaplication.home.data.model.ui.SearchItemResult
import com.ingeacev.mymeliaplication.home.presentation.compose.screen.ProductsList

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

@Composable
fun HomeMainContent(
    value: SearchItemResult?,
    onSearchQuery: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var showSnackbar by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    val statusBarsInsets = WindowInsets.statusBars.asPaddingValues()

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = statusBarsInsets.calculateTopPadding())
    ) {
        SearchInput(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onSearch = {
                if (searchQuery.isBlank()) {
                    showSnackbar = true
                    message = "La búsqueda no puede estar vacía"
                } else {
                    Log.d("Search", "Buscando: $searchQuery")
                    onSearchQuery(searchQuery)
                }
            }
        )

        Spacer(modifier = Modifier.height(spacing_xxxs))

        ProductsList(data = value)
    }

    if (showSnackbar) {
        ModalSnackbar(
            message = message,
            actionLabel = "OK",
            onActionClick = { showSnackbar = false },
            onDismiss = { showSnackbar = false }
        )
    }
}
