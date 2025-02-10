package com.ingeacev.mymeliaplication.home.presentation.compose

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.ingeacev.mymeliaplication.commons.utils.font_size_14
import com.ingeacev.mymeliaplication.commons.utils.font_size_16
import com.ingeacev.mymeliaplication.commons.utils.font_size_18
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxs
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxxs
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxxxs

@Composable
fun ProductCard(
    title: String? = "",
    price: String? = "",
    currency: String? = "",
    imageUrl: String? = "",
    condition: String? = "",
    freeShipping: Boolean? = false
) {

    OutlinedCard(
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(spacing_xxxxs, Color(0xFF00002A)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing_xxs),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFDDE7F3),
        ),
    ) {
        Column(modifier = Modifier.padding(spacing_xxs)) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Image about the product",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .sizeIn(maxWidth = 500.dp, maxHeight = 500.dp)
                    .aspectRatio(2/3f)
                    .clip(MaterialTheme.shapes.small)
            )

            Spacer(modifier = Modifier.height(spacing_xxs))

            Text(
                text = title.toString(),
                fontSize = font_size_16,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(spacing_xxxs))

            Text(
                text = "$currency $price",
                fontSize = font_size_18,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF388E3C)
            )

            Spacer(modifier = Modifier.height(spacing_xxxs))

            Text(
                text = "Condición: $condition",
                fontSize = font_size_14,
                color = Color.Gray
            )

            if (freeShipping == true) {
                Text(
                    text = "Envío gratis",
                    fontSize = font_size_14,
                    color = Color.Blue
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewProductCard() {
    ProductCard(
        title = "Samsung Galaxy J4+ Dual Sim 32 Gb Negro",
        price = "19609",
        currency = "ARS",
        imageUrl = "https://http2.mlstatic.com/D_889938-MLA40645964182_022020-I.jpg",
        condition = "Nuevo",
        freeShipping = true
    )
}
