package com.ingeacev.mymeliaplication.core.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.net.toUri

/**
 * Created by Alejandro Acevedo on 10,febrero,2025
 */

fun openMercadoLibre(context: Context, itemId: String, permalink: String) {
    val mercadoLibreUri = Uri.parse("meli://item/$itemId")
    val webUri = permalink.toUri()

    val intent = Intent(Intent.ACTION_VIEW, mercadoLibreUri).apply {
        `package` = "com.mercadolibre"
    }

    try {
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // Si la app de MercadoLibre no está instalada, abre en el navegador
        context.startActivity(Intent(Intent.ACTION_VIEW, webUri))
    }
}