package com.ingeacev.mymeliaplication.core.navigation

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto
import kotlinx.serialization.Serializable


@Serializable
object Home

@Serializable
data class Details(val searchResultDto: SearchResultDto)