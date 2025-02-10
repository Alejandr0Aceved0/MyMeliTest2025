package com.ingeacev.mymeliaplication.home.data.model.ui

import com.ingeacev.mymeliaplication.home.data.model.remote.PagingDto
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResultDto

/**
 * Created by Alejandro Acevedo on 08,febrero,2025
 */
data class SearchItemResult (
    val siteId: String,
    val query: String,
    val paging: PagingDto,
    val results: List<SearchResultDto>
)