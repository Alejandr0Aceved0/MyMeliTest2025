package com.ingeacev.mymeliaplication.home.presentation.compose

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun MarketplaceCard(
    title: String,
    price: String,
    currency: String,
    imageUrl: String,
    condition: String,
    freeShipping: Boolean
) {
    println(imageUrl)
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$currency $price",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF388E3C)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Condición: $condition",
                fontSize = 14.sp,
                color = Color.Gray
            )
            if (freeShipping) {
                Text(
                    text = "Envío gratis",
                    fontSize = 14.sp,
                    color = Color.Blue
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMarketplaceCard() {
    MarketplaceCard(
        title = "Samsung Galaxy J4+ Dual Sim 32 Gb Negro",
        price = "19609",
        currency = "ARS",
        imageUrl = "https://cdn.pixabay.com/photo/2024/12/28/03/20/parrot-9295172_1280.jpg",
        condition = "Nuevo",
        freeShipping = true
    )
}
