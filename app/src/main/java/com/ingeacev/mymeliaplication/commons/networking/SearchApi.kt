package com.ingeacev.mymeliaplication.commons.networking

import com.ingeacev.mymeliaplication.home.data.model.remote.CategoriesDto
import com.ingeacev.mymeliaplication.home.data.model.remote.ItemDescriptionResponseDto
import com.ingeacev.mymeliaplication.home.data.model.remote.SearchResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("/sites/MLA/categories?category=MLA1055")
    suspend fun getCategories(): Response<List<CategoriesDto>?>

    @GET("/sites/MLA/search")
    suspend fun searchByInputChange(
        @Query("q") query: String
    ): Response<SearchResponseDto?>

    @GET("/sites/MLA/search?q=Motorola%20G6")
    suspend fun searchByDefault(): Response<SearchResponseDto?>

    @GET("/items/{value}/description")
    suspend fun getItemDescription(
        @Query("value") query: String
    ): Response<ItemDescriptionResponseDto?>
}