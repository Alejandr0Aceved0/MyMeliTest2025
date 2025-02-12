package com.ingeacev.mymeliaplication.home.presentation.compose.screen

/**
 * Created by Alejandro Acevedo on 11,febrero,2025
 */

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.ingeacev.mymeliaplication.core.data.model.Resource
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Mockk
    lateinit var homeScreenViewModel: HomeScreenViewModel

    @RelaxedMockK
    lateinit var navigateToDetail: (SearchResultDto) -> Unit

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `HomeScreen when loading products then show loading indicator`() {
        // Given
        coEvery { homeScreenViewModel.getDefaultProductsState } returns flowOf(Resource.Loading())

        // When
        composeTestRule.setContent {
            HomeScreen(homeScreenViewModel = homeScreenViewModel, navigateToDetail = navigateToDetail)
        }
        // Then
        composeTestRule.onNodeWithText("Loading...").assertExists()
    }

    @Test
    fun `HomeScreen when generic error then show error screen`() {
        // Given
        val errorMessage = "Error de red"
        coEvery { homeScreenViewModel.getDefaultProductsState } returns flowOf(Resource.GenericDataError(errorMessage = errorMessage))

        // When
        composeTestRule.setContent {
            HomeScreen(homeScreenViewModel = homeScreenViewModel, navigateToDetail = navigateToDetail)
        }

        // Then
        composeTestRule.onNodeWithText(errorMessage).assertExists()
        composeTestRule.onNodeWithText("TryAgain").assertExists()
    }

    @Test
    fun `HomeScreen when try again clicked then call getDefaultProducts`() {
        // Given
        coEvery { homeScreenViewModel.getDefaultProductsState } returns flowOf(Resource.GenericDataError())
        coEvery { homeScreenViewModel.getDefaultProducts() } returns Unit

        // When
        composeTestRule.setContent {
            HomeScreen(homeScreenViewModel = homeScreenViewModel, navigateToDetail = navigateToDetail)
        }

        composeTestRule.onNodeWithText("TryAgain").performClick()

        // Then
        coVerify(exactly = 2) { homeScreenViewModel.getDefaultProducts() }
    }

    @Test
    fun `HomeScreen when success load products then show HomeMainContent`() {
        // Given
        val products = listOf(SearchResultDto(id = "1", title = "Producto 1"), SearchResultDto(id = "2", title = "Producto 2"))
        coEvery { homeScreenViewModel.getDefaultProductsState } returns flowOf(Resource.Success(data = products))

        // When
        composeTestRule.setContent {
            HomeScreen(homeScreenViewModel = homeScreenViewModel, navigateToDetail = navigateToDetail)
        }

        // Then
        composeTestRule.onNodeWithText("Producto 1").assertExists()
        composeTestRule.onNodeWithText("Producto 2").assertExists()
    }
    @Test
    fun `HomeScreen when first open screen then call getDefaultProducts`(){
        // Given
        coEvery { homeScreenViewModel.getDefaultProductsState } returns flowOf(Resource.Loading())

        // When
        composeTestRule.setContent {
            HomeScreen(homeScreenViewModel = homeScreenViewModel, navigateToDetail = navigateToDetail)
        }

        // Then
        coVerify(exactly = 1) { homeScreenViewModel.getDefaultProducts() }
    }
}