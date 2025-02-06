package com.ingeacev.mymeliaplication.home.presentation.compose.screen

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import androidx.lifecycle.ViewModel
import com.ingeacev.mymeliaplication.home.domain.usecase.GetCategoriesRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject() constructor(
    private val getCategoriesRemoteUseCase: GetCategoriesRemoteUseCase
) : ViewModel() {
}