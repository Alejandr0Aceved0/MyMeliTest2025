package com.ingeacev.mymeliaplication.home.presentation.compose.screen

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.ui.SearchItemResult
import com.ingeacev.mymeliaplication.home.domain.usecase.GetCategoriesUseCase
import com.ingeacev.mymeliaplication.home.domain.usecase.SearchProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject() constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val searchProductsUseCase: SearchProductsUseCase,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _getDefaultProductsState = MutableStateFlow<Resource<SearchItemResult>>(Resource.Loading())
    val getDefaultProductsState: StateFlow<Resource<SearchItemResult>>
        get() = _getDefaultProductsState.asStateFlow()

    init {
        getDefaultProducts()
    }

    fun searchProducts(query: String) {
        viewModelScope.launch {

            searchProductsUseCase.searchProducts(query).collectLatest { response ->
                _getDefaultProductsState.update {
                    response
                }
            }
        }
    }

    fun getDefaultProducts() {
        viewModelScope.launch(coroutineDispatcher) {
            searchProductsUseCase.getDefaultProducts().collectLatest { response ->
                _getDefaultProductsState.update {
                    response
                }

            }
        }
    }
}