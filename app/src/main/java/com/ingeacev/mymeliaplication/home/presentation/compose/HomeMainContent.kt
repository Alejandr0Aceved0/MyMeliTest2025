package com.ingeacev.mymeliaplication.home.presentation.compose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ingeacev.mymeliaplication.commons.utils.spacing_sm
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxs
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import com.ingeacev.mymeliaplication.home.data.model.ui.SearchItemResult
import com.ingeacev.mymeliaplication.home.presentation.compose.screen.ProductsList
import kotlinx.coroutines.launch

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMainContent(
    value: SearchItemResult?,
    onSearchQuery: (String) -> Unit,
    onNavigateToIncidentDetail: (SearchResultDto) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = spacing_xxs,
                shape = RoundedCornerShape(
                    bottomStart = spacing_sm,
                    bottomEnd = spacing_sm
                )
            ) {
                SearchInput(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it },
                    onSearch = {
                        if (searchQuery.isBlank()) {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("La búsqueda no puede estar vacía")
                            }
                        } else {
                            Log.d("Search", "Buscando: $searchQuery")
                            onSearchQuery(searchQuery)
                        }
                    }
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ProductsList(
                data = value,
                onActivityClick = { activity: SearchResultDto ->
                    onNavigateToIncidentDetail(activity)
                }
            )
        }
    }
}
