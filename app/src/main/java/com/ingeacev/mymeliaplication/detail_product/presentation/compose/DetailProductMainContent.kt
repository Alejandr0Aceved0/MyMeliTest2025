package com.ingeacev.mymeliaplication.detail_product.presentation.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ingeacev.mymeliaplication.commons.presentation.SimpleButton
import com.ingeacev.mymeliaplication.commons.utils.font_size_16
import com.ingeacev.mymeliaplication.commons.utils.font_size_18
import com.ingeacev.mymeliaplication.commons.utils.font_size_20
import com.ingeacev.mymeliaplication.commons.utils.spacing_sm
import com.ingeacev.mymeliaplication.commons.utils.spacing_xs
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxs
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxxxs
import com.ingeacev.mymeliaplication.core.utils.openMercadoLibre
import com.ingeacev.mymeliaplication.detail_product.data.model.ui.ItemDescription
import com.ingeacev.mymeliaplication.ui.theme.AmericanGreen
import com.ingeacev.mymeliaplication.ui.theme.DarkBlue_Gray
import com.ingeacev.mymeliaplication.ui.theme.Jasper

/**
 * Created by Alejandro Acevedo on 10,febrero,2025
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailProductMainContent(
    value: ItemDescription,
    navigateBack: () -> Unit
) {

    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = spacing_xxs,
                shape = RoundedCornerShape(bottomStart = spacing_sm, bottomEnd = spacing_sm)
            ) {
                TopAppBar(
                    title = { Text(text = "Detalles del Producto") },
                    navigationIcon = {
                        IconButton(onClick = navigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.onBackground,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(spacing_xxs))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(spacing_sm)
                        .background(Color(0xFFDDE7F3))
                ) {

                    AsyncImage(
                        model = value.thumbnail,
                        contentDescription = value.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(spacing_xs)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(spacing_xs))

                    Text(text = value.title, fontSize = font_size_20, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(spacing_xxs))

                    Text(
                        text = "${value.currencyId} ${value.price}",
                        fontSize = font_size_18,
                        fontWeight = FontWeight.Medium,
                        color = AmericanGreen
                    )

                    Spacer(modifier = Modifier.height(spacing_xxs))

                    Text(text = "Condición: ${value.condition}", fontSize = font_size_18)

                    Spacer(modifier = Modifier.height(spacing_xxs))

                    Text(
                        text = "Stock disponible: ${value.availableQuantity}",
                        fontSize = font_size_18
                    )

                    Spacer(modifier = Modifier.height(spacing_xxs))

                    if (value.shipping?.freeShipping == true) {

                        Text(text = "Envío: Gratis 🚚", fontSize = font_size_16, color = Color.Blue)
                    } else {

                        Text(
                            text = "Envío: No incluido",
                            fontSize = font_size_16,
                            color = DarkBlue_Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(spacing_xxs))

                    if (value.acceptsMercadoPago) {

                        Text(
                            text = "✔ Acepta Mercado Pago",
                            fontSize = font_size_16,
                            color = AmericanGreen
                        )
                    } else {

                        Text(
                            text = "✖ No acepta Mercado Pago",
                            fontSize = font_size_16,
                            color = Jasper
                        )
                    }

                    Spacer(modifier = Modifier.height(spacing_xxs))

                    Text(text = "Mas info: ${value.plainText}", fontSize = font_size_18)

                    Spacer(modifier = Modifier.height(spacing_xs))

                    SimpleButton(
                        onClick = { openMercadoLibre(context, value.id, value.permalink) },
                        modifier = Modifier.fillMaxWidth(),
                        isEnable = true,
                        buttonColor = ButtonColors(
                            containerColor = Color.White,
                            contentColor = MaterialTheme.colorScheme.onBackground,
                            disabledContainerColor = Color.White,
                            disabledContentColor = MaterialTheme.colorScheme.onBackground
                        ),
                        buttonText = "Ver en MercadoLibre",
                        buttonBorder = BorderStroke(
                            spacing_xxxxs,
                            MaterialTheme.colorScheme.onBackground
                        ),
                        buttonShape = RoundedCornerShape(0.dp),
                    )
                }
            }
        }
    }
}
