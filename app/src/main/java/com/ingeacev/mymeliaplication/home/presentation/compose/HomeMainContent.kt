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
import androidx.compose.ui.unit.dp
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import com.ingeacev.mymeliaplication.home.presentation.compose.screen.ProductsList

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

@Composable
fun HomeMainContent(value: Resource.Success<SearchResponseDto>) {

    var searchQuery by remember { mutableStateOf("") }
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
                Log.d("Search", "Buscando: $searchQuery")
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        ProductsList(
            data = value.data
        )
    }
}