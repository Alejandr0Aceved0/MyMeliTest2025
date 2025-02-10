package com.ingeacev.mymeliaplication.home.presentation.compose.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ingeacev.mymeliaplication.commons.presentation.GeneralErrorScreen
import com.ingeacev.mymeliaplication.commons.presentation.LoadingIndicator
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.presentation.compose.HomeMainContent

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = Unit) {
        homeScreenViewModel.getDefaultProducts()
    }

    when (val value = homeScreenViewModel.getDefaultProductsState.collectAsStateWithLifecycle().value) {
        is Resource.GenericDataError -> {
            GeneralErrorScreen(
                errorTitle = value.errorMessage ?: "GenericError ",
                onActionButtonClick = { homeScreenViewModel.getDefaultProducts() },
                actionButtonText = "TryAgain"
            )
        }

        is Resource.Loading -> {
            LoadingIndicator()
        }

        is Resource.Sleep -> TODO()

        is Resource.Success -> {
            HomeMainContent(
                value = value.data,
                onSearchQuery = { query -> homeScreenViewModel.searchProducts(query) }
            )
        }
    }
}
