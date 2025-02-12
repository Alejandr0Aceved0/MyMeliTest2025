package com.ingeacev.mymeliaplication.detail_product.presentation.compose

import android.content.Context
import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Alejandro Acevedo on 11,febrero,2025
 */

@RunWith(JUnit4::class)
class DetailProductMainContentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @RelaxedMockK
    lateinit var navigateBack: () -> Unit

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `DetailProductMainContent when start then show title`() {
        // Given
        val itemDescription = ItemDescription(id = "1", title = "Producto 1")

        // When
        composeTestRule.setContent {
            DetailProductMainContent(value = itemDescription, navigateBack = navigateBack)
        }

        // Then
        composeTestRule.onNodeWithText("Detalles del Producto").assertIsDisplayed()
    }

    @Test
    fun `DetailProductMainContent when click back then call navigateBack`() {
        // Given
        val itemDescription = ItemDescription(id = "1", title = "Producto 1")
        coEvery { navigateBack.invoke() } returns Unit
        // When
        composeTestRule.setContent {
            DetailProductMainContent(value = itemDescription, navigateBack = navigateBack)
        }

        composeTestRule.onNodeWithText("Volver").performClick()

        // Then
        coVerify(exactly = 1) { navigateBack.invoke() }
    }
    @Test
    fun `DetailProductMainContent when have itemDescription then show info`(){
        // Given
        val itemDescription = ItemDescription(
            id = "1",
            title = "Producto 1",
            currencyId = "$",
            price = 1000,
            condition = "Nuevo",
            availableQuantity = 10,
            shipping = ItemDescription.Shipping(true),
            acceptsMercadoPago = true,
            plainText = "Mas informacion",
            thumbnail = ""
        )

        // When
        composeTestRule.setContent {
            DetailProductMainContent(value = itemDescription, navigateBack = navigateBack)
        }
        // Then
        composeTestRule.onNodeWithText("Producto 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("$ 1000").assertIsDisplayed()
        composeTestRule.onNodeWithText("Condición: Nuevo").assertIsDisplayed()
        composeTestRule.onNodeWithText("Stock disponible: 10").assertIsDisplayed()
        composeTestRule.onNodeWithText("Envío: Gratis 🚚").assertIsDisplayed()
        composeTestRule.onNodeWithText("✔ Acepta Mercado Pago").assertIsDisplayed()
        composeTestRule.onNodeWithText("Mas info: Mas informacion").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ver en MercadoLibre").assertIsDisplayed()
    }
    @Test
    fun `DetailProductMainContent when click button then open intent`(){
        //Given
        val context: Context = mockk(relaxed = true)
        val itemDescription = ItemDescription(
            id = "1",
            title = "Producto 1",
            currencyId = "$",
            price = 1000,
            condition = "Nuevo",
            availableQuantity = 10,
            shipping = ItemDescription.Shipping(true),
            acceptsMercadoPago = true,
            plainText = "Mas informacion",
            thumbnail = "",
            permalink = "https://www.mercadolibre.com.ar/"
        )
        coEvery { context.startActivity(any()) } returns Unit
        //When
        composeTestRule.setContent {
            DetailProductMainContent(value = itemDescription, navigateBack = navigateBack)
        }
        composeTestRule.onNodeWithText("Ver en MercadoLibre").performClick()

        //Then
        coVerify(exactly = 1){ context.startActivity(any<Intent>())}
    }
}