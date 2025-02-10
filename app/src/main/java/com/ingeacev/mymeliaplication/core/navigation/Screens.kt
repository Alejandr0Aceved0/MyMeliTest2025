package com.ingeacev.mymeliaplication.core.navigation

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Details(val name: String)

@Serializable
object Search
