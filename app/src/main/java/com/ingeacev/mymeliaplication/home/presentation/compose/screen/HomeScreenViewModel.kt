package com.ingeacev.mymeliaplication.home.presentation.compose.screen

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.local.CategoriesDao
import com.ingeacev.mymeliaplication.home.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject() constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _services = MutableStateFlow<Resource<List<CategoriesDao?>>>(
        Resource.Sleep()
    )

    init {
        getServices()
    }

    fun getServices() {
        viewModelScope.launch(coroutineDispatcher) {
            _services.update { Resource.Loading() }
            getCategoriesUseCase().collectLatest { response ->
//                _services.update { response }
            }
        }
    }
}