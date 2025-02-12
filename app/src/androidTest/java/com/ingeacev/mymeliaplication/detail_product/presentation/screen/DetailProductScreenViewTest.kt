package com.ingeacev.mymeliaplication.detail_product.presentation.screen

/**
 * Created by Alejandro Acevedo on 11,febrero,2025
 */

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import com.ingeacev.mymeliaplication.home.data.model.ui.SearchItemResult
import com.ingeacev.mymeliaplication.home.presentation.compose.HomeMainContent
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class HomeMainContentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @RelaxedMockK
    lateinit var onSearchQuery: (String) -> Unit

    @RelaxedMockK
    lateinit var onNavigateToIncidentDetail: (SearchResultDto) -> Unit

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `HomeMainContent when start then show search input`() {
        // Given
        val searchItemResult = SearchItemResult()

        // When
        composeTestRule.setContent {
            HomeMainContent(value = searchItemResult, onSearchQuery = onSearchQuery, onNavigateToIncidentDetail = onNavigateToIncidentDetail)
        }

        // Then
        composeTestRule.onNodeWithText("Buscar").assertIsDisplayed()
    }

    @Test
    fun `HomeMainContent when text change then update query`() {
        // Given
        val searchItemResult = SearchItemResult()
        val query = "Test"

        // When
        composeTestRule.setContent {
            HomeMainContent(value = searchItemResult, onSearchQuery = onSearchQuery, onNavigateToIncidentDetail = onNavigateToIncidentDetail)
        }
        composeTestRule.onNodeWithText("Buscar").performTextInput(query)

        // Then
        composeTestRule.onNodeWithText(query).assertExists()
    }
    @Test
    fun `HomeMainContent when search empty query then show snackbar`()= runTest{
        //Given
        val searchItemResult = SearchItemResult()
        val snackbarHostState = SnackbarHostState()
        val coroutineDispatcher = UnconfinedTestDispatcher(testScheduler)
        //When
        composeTestRule.setContent {
            val scope = rememberCoroutineScope()
            HomeMainContent(value = searchItemResult, onSearchQuery = onSearchQuery, onNavigateToIncidentDetail = onNavigateToIncidentDetail)
        }
        composeTestRule.onNodeWithText("Buscar").performTextInput("")
        composeTestRule.onNodeWithText("Buscar").performClick()
        //Then
        val job = launch(coroutineDispatcher) {
            snackbarHostState.showSnackbar("La búsqueda no puede estar vacía")
        }
        job.join()
    }
    @Test
    fun `HomeMainContent when search query then call onSearchQuery`(){
        //Given
        val searchItemResult = SearchItemResult()
        val query = "Test"
        coEvery { onSearchQuery(query) } returns Unit
        //When
        composeTestRule.setContent {
            HomeMainContent(value = searchItemResult, onSearchQuery = onSearchQuery, onNavigateToIncidentDetail = onNavigateToIncidentDetail)
        }
        composeTestRule.onNodeWithText("Buscar").performTextInput(query)
        composeTestRule.onNodeWithText("Buscar").performClick()
        //Then
        coVerify(exactly = 1){onSearchQuery(query)}
    }
    @Test
    fun `HomeMainContent when click product then call onNavigateToIncidentDetail`() {
        // Given
        val product = SearchResultDto(id = "1", title = "Producto 1")
        val searchItemResult = SearchItemResult(
            searchResultDtoList = listOf(product)
        )
        coEvery { onNavigateToIncidentDetail(product) } returns Unit
        // When
        composeTestRule.setContent {
            HomeMainContent(value = searchItemResult, onSearchQuery = onSearchQuery, onNavigateToIncidentDetail = onNavigateToIncidentDetail)
        }
        composeTestRule.onNodeWithText("Producto 1").performClick()

        // Then
        coVerify(exactly = 1) { onNavigateToIncidentDetail(product) }
    }
}