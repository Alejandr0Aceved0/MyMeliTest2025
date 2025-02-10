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
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxs
import com.ingeacev.mymeliaplication.commons.utils.spacing_xxxs
import com.ingeacev.mymeliaplication.home.data.model.ui.SearchItemResult
import com.ingeacev.mymeliaplication.home.presentation.compose.ProductCard

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */

@Composable
fun ProductsList(data: SearchItemResult?) {

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDDE7F3))
            .padding(spacing_xxs),
        columns = GridCells.Fixed(2),
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(spacing_xxxs),
        reverseLayout = false,
        verticalArrangement = Arrangement.spacedBy(spacing_xxs),
        horizontalArrangement = Arrangement.spacedBy(spacing_xxs),
        userScrollEnabled = true
    ) {

        data?.results?.forEach {
            item {

                ProductCard(
                    title = it.title,
                    price = it.installments?.amount.toString(),
                    currency = it.currencyId,
                    imageUrl = it.thumbnail,
                    condition = it.condition,
                    freeShipping = it.shipping?.freeShipping
                )

                Spacer(modifier = Modifier.padding(spacing_xxs))
            }
        }
    }
}
