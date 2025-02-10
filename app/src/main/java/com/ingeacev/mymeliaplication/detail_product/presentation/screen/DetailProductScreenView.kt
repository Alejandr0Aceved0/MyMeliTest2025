package com.ingeacev.mymeliaplication.detail_product.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import com.ingeacev.mymeliaplication.detail_product.domain.usecase.ProductUseCase
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Alejandro Acevedo on 10,febrero,2025
 */

@HiltViewModel
class DetailProductScreenView @Inject() constructor(
    private val productUseCase: ProductUseCase,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _getProductProductsState = MutableStateFlow<Resource<ItemDescription>>(Resource.Loading())
    val getProductProductsState: StateFlow<Resource<ItemDescription>>
        get() = _getProductProductsState.asStateFlow()

    fun getProductDetails(searchResultDto: SearchResultDto) {
        viewModelScope.launch(coroutineDispatcher) {
            productUseCase.invoke(searchResultDto).collectLatest { response ->
                _getProductProductsState.update {
                    response
                }
            }
        }
    }
}