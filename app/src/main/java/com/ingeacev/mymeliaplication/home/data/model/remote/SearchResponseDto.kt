package com.ingeacev.mymeliaplication.home.data.model.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.google.gson.annotations.SerializedName
import com.ingeacev.mymeliaplication.home.data.model.ui.SearchItemResult
import java.math.BigInteger

data class SearchResponseDto(
    @SerializedName("site_id") val siteId: String,
    @SerializedName("query") val query: String,
    @SerializedName("paging") val paging: PagingDto,
    @SerializedName("results") val results: List<SearchResultDto>
)

fun SearchResponseDto.toSearchItemResult() = SearchItemResult(
    siteId = this.siteId,
    query = this.query,
    paging = this.paging,
    results = this.results
)

data class PagingDto(
    @SerializedName("total") val total: Int? = 0,
    @SerializedName("offset") val offset: Int? = 0,
    @SerializedName("limit") val limit: Int? = 0,
    @SerializedName("primary_results") val primaryResults: Int? = 0,
)

data class SearchResultDto(
    @SerializedName("id") val id: String? = "",
    @SerializedName("site_id") val siteId: String? = "",
    @SerializedName("title") val title: String? = "",
    @SerializedName("seller") val seller: SellerDto? = SellerDto(),
    @SerializedName("price") val price: Double? = 0.0,
    @SerializedName("currency_id") val currencyId: String? = "",
    @SerializedName("available_quantity") val availableQuantity: Int? = 0,
    @SerializedName("buying_mode") val buyingMode: String? = "",
    @SerializedName("listing_type_id") val listingTypeId: String? = "",
    @SerializedName("stop_time") val stopTime: String? = "",
    @SerializedName("condition") val condition: String? = "",
    @SerializedName("permalink") val permalink: String? = "",
    @SerializedName("thumbnail") val thumbnail: String? = "",
    @SerializedName("accepts_mercadopago") val acceptsMercadoPago: Boolean? = false,
    @SerializedName("installments") val installments: InstallmentsDto? = InstallmentsDto(),
    @SerializedName("shipping") val shipping: ShippingDto? = ShippingDto(),
    @SerializedName("attributes") val attributes: List<AttributeDto>? = listOf(),
    @SerializedName("original_price") val originalPrice: Double? = 0.0,
    @SerializedName("category_id") val categoryId: String? = "",
    @SerializedName("official_store_id") val officialStoreId: Int? = 0,
    @SerializedName("catalog_product_id") val catalogProductId: String? = "",
    @SerializedName("catalog_listing") val catalogListing: Boolean? = false,
)

data class SellerDto(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("power_seller_status") val powerSellerStatus: String? = "",
    @SerializedName("car_dealer") val carDealer: Boolean? = false,
    @SerializedName("real_estate_agency") val realEstateAgency: Boolean? = false,
    @SerializedName("tags") val tags: List<String> = listOf(),
)

data class InstallmentsDto(
    @SerializedName("quantity") val quantity: Int? = 0,
    @SerializedName("amount") val amount: Double? = 0.0,
    @SerializedName("rate") val rate: Double? = 0.0,
    @SerializedName("currency_id") val currencyId: String? = ""
)

data class ShippingDto(
    @SerializedName("free_shipping") val freeShipping: Boolean? = false,
    @SerializedName("mode") val mode: String? = "",
    @SerializedName("tags") val tags: List<String>? = listOf(),
    @SerializedName("logistic_type") val logisticType: String? = "",
    @SerializedName("store_pick_up") val storePickUp: Boolean? = false,
    @SerializedName("state") val state: StateDto? = StateDto(),
    @SerializedName("city") val city: CityDto? = CityDto(),
    @SerializedName("latitude") val latitude: String? = "",
    @SerializedName("longitude") val longitude: String? = "",
)

data class AttributeDto(
    @SerializedName("name") val name: String? = "",
    @SerializedName("value_id") val valueId: String?? = "",
    @SerializedName("value_name") val valueName: String? = "",
    @SerializedName("value_struct") val valueStruct: Any?? = "",
    @SerializedName("attribute_group_id") val attributeGroupId: String? = "",
    @SerializedName("attribute_group_name") val attributeGroupName: String? = "",
    @SerializedName("source") val source: BigInteger? = 0.toBigInteger(),
    @SerializedName("id") val id: String? = "",
)

data class StateDto(
    @SerializedName("id") val id: String? = "",
    @SerializedName("name") val name: String? = "",
)

data class CityDto(
    @SerializedName("id") val id: String? = "",
    @SerializedName("name") val name: String? = "",
)