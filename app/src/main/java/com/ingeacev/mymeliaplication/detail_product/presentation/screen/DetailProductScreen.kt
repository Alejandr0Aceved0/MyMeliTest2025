package com.ingeacev.mymeliaplication.detail_product.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ingeacev.mymeliaplication.commons.presentation.GeneralErrorScreen
import com.ingeacev.mymeliaplication.commons.presentation.LoadingIndicator
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.detail_product.presentation.compose.DetailProductMainContent
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

@Composable
fun DetailProductScreen(
    detailProductScreenView: DetailProductScreenView = hiltViewModel(),
    searchResultDto: SearchResultDto,
    navigateBack: () -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        detailProductScreenView.getProductDetails(searchResultDto)
    }

    when (val value =
        detailProductScreenView.getProductProductsState.collectAsStateWithLifecycle().value) {
        is Resource.GenericDataError -> {
            GeneralErrorScreen(
                errorTitle = value.errorMessage ?: "GenericError ",
                onActionButtonClick = { detailProductScreenView.getProductDetails(searchResultDto) },
                actionButtonText = "TryAgain"
            )
        }

        is Resource.Loading -> {
            LoadingIndicator()
        }

        is Resource.Sleep -> TODO()

        is Resource.Success -> {

            value.data?.let { product ->

                DetailProductMainContent(
                    value = product,
                    navigateBack = navigateBack
                )
            }
        }
    }
}