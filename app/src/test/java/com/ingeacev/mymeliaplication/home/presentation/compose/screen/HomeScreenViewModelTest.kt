package com.ingeacev.mymeliaplication.home.presentation.compose.screen

/**
 * Created by Alejandro Acevedo on 11,febrero,2025
 */

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.ui.SearchItemResult
import com.ingeacev.mymeliaplication.home.domain.usecase.GetCategoriesUseCase
import com.ingeacev.mymeliaplication.home.domain.usecase.SearchProductsUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class HomeScreenViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var getCategoriesUseCase: GetCategoriesUseCase

    @RelaxedMockK
    lateinit var searchProductsUseCase: SearchProductsUseCase

    private lateinit var homeScreenViewModel: HomeScreenViewModel

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        homeScreenViewModel = HomeScreenViewModel(getCategoriesUseCase, searchProductsUseCase, UnconfinedTestDispatcher())
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `HomeScreenViewModel when getDefaultProducts then loading state`() = runTest {
        // Given
        coEvery { searchProductsUseCase.getDefaultProducts() } returns flowOf(Resource.Loading())

        // When
        homeScreenViewModel.getDefaultProducts()

        // Then
        assert(homeScreenViewModel.getDefaultProductsState.value == Resource.Loading())
    }

    @Test
    fun `HomeScreenViewModel when getDefaultProducts then success state`() = runTest {
        // Given
        val searchItemResult = SearchItemResult()
        coEvery { searchProductsUseCase.getDefaultProducts() } returns flowOf(Resource.Success(searchItemResult))

        // When
        homeScreenViewModel.getDefaultProducts()

        // Then
        assert(homeScreenViewModel.getDefaultProductsState.value == Resource.Success(searchItemResult))
    }

    @Test
    fun `HomeScreenViewModel when getDefaultProducts then error state`() = runTest {
        // Given
        coEvery { searchProductsUseCase.getDefaultProducts() } returns flowOf(Resource.GenericDataError())

        // When
        homeScreenViewModel.getDefaultProducts()

        // Then
        assert(homeScreenViewModel.getDefaultProductsState.value == Resource.GenericDataError())
    }

    @Test
    fun `HomeScreenViewModel when searchProducts then loading state`() = runTest {
        // Given
        val query = "query"
        coEvery { searchProductsUseCase.searchProducts(query) } returns flowOf(Resource.Loading())

        // When
        homeScreenViewModel.searchProducts(query)

        // Then
        assert(homeScreenViewModel.getDefaultProductsState.value == Resource.Loading())
    }

    @Test
    fun `HomeScreenViewModel when searchProducts then success state`() = runTest {
        // Given
        val query = "query"
        val searchItemResult = SearchItemResult()
        coEvery { searchProductsUseCase.searchProducts(query) } returns flowOf(Resource.Success(searchItemResult))

        // When
        homeScreenViewModel.searchProducts(query)

        // Then
        assert(homeScreenViewModel.getDefaultProductsState.value == Resource.Success(searchItemResult))
        coVerify(exactly = 1){searchProductsUseCase.searchProducts(query)}
    }
    @Test
    fun `HomeScreenViewModel when searchProducts then error state`() = runTest {
        // Given
        val query = "query"
        coEvery { searchProductsUseCase.searchProducts(query) } returns flowOf(Resource.GenericDataError())

        // When
        homeScreenViewModel.searchProducts(query)

        // Then
        assert(homeScreenViewModel.getDefaultProductsState.value == Resource.GenericDataError())
    }
    @Test
    fun `HomeScreenViewModel when init then call getDefaultProducts`() = runTest {
        //Given
        coEvery { searchProductsUseCase.getDefaultProducts() } returns flowOf(Resource.Loading())
        // When
        homeScreenViewModel = HomeScreenViewModel(getCategoriesUseCase, searchProductsUseCase, UnconfinedTestDispatcher())
        // Then
        coVerify(exactly = 1){searchProductsUseCase.getDefaultProducts()}
    }

}