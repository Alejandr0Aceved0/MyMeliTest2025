package com.ingeacev.mymeliaplication.home.presentation.compose

import androidx.compose.runtime.Composable
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import com.ingeacev.mymeliaplication.home.presentation.compose.screen.ProductsList

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

@Composable
fun HomeMainContent(value: Resource.Success<SearchResponseDto>) {

    SearchInput(
        onSearch = { query ->
            // Aquí se ejecuta la búsqueda con el texto 'query'
            println("Realizando búsqueda de: $query")
        }
    )

    ProductsList(
        data = value.data
    )
}