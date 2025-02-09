package com.ingeacev.mymeliaplication.home.presentation.compose.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import com.ingeacev.mymeliaplication.home.presentation.compose.ProductCard

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

@Composable
fun ProductsList(data: List<SearchResponseDto>?) {
    if (!data.isNullOrEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            data[0].results.forEach {
                item {
                    ProductCard(
                        title = it.title,
                        price = it.installments.amount.toString(),
                        currency = it.currencyId,
                        imageUrl = it.thumbnail,
                        condition = it.condition,
                        freeShipping = it.shipping.freeShipping
                    )

                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}
