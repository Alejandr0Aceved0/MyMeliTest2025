package com.ingeacev.mymeliaplication.home.data.model.ui

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */
data class SearchItemResult (
    val title: String,
    val price: String,
    val currency: String,
    val imageUrl: String,
    val condition: String,
    val freeShipping: Boolean
)