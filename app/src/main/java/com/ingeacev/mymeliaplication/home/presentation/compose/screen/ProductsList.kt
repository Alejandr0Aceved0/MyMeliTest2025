package com.ingeacev.mymeliaplication.home.presentation.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import com.ingeacev.mymeliaplication.home.presentation.compose.ProductCard

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

@Composable
fun ProductsList(data: SearchResponseDto?) {

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDDE7F3))
            .padding(10.dp),
        columns = GridCells.Fixed(2),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(5.dp),
        reverseLayout = false,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = true
    ) {

        data?.results?.forEach {
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
