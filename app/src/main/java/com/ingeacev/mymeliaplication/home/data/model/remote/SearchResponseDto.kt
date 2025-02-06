package com.ingeacev.mymeliaplication.home.data.model.remote

/**
 * Created by Alejandro Acevedo on 06,febrero,2025
 */

import com.google.gson.annotations.SerializedName

data class SearchResponseDto(
    @SerializedName("site_id") val siteId: String,
    @SerializedName("query") val query: String,
    @SerializedName("paging") val paging: PagingDto,
    @SerializedName("results") val results: List<SearchResultDto>
)

data class PagingDto(
    @SerializedName("total") val total: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("primary_results") val primaryResults: Int
)

data class SearchResultDto(
    @SerializedName("id") val id: String,
    @SerializedName("site_id") val siteId: String,
    @SerializedName("title") val title: String,
    @SerializedName("seller") val seller: SellerDto?,
    @SerializedName("price") val price: Double,
    @SerializedName("currency_id") val currencyId: String,
    @SerializedName("available_quantity") val availableQuantity: Int,
    @SerializedName("buying_mode") val buyingMode: String,
    @SerializedName("listing_type_id") val listingTypeId: String,
    @SerializedName("stop_time") val stopTime: String,
    @SerializedName("condition") val condition: String,
    @SerializedName("permalink") val permalink: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("accepts_mercadopago") val acceptsMercadoPago: Boolean,
    @SerializedName("installments") val installments: InstallmentsDto,
    @SerializedName("shipping") val shipping: ShippingDto,
    @SerializedName("attributes") val attributes: List<AttributeDto>,
    @SerializedName("original_price") val originalPrice: Double?,
    @SerializedName("category_id") val categoryId: String,
    @SerializedName("official_store_id") val officialStoreId: Int?,
    @SerializedName("catalog_product_id") val catalogProductId: String?,
    @SerializedName("catalog_listing") val catalogListing: Boolean
)

data class SellerDto(
    @SerializedName("id") val id: Int,
    @SerializedName("power_seller_status") val powerSellerStatus: String?,
    @SerializedName("car_dealer") val carDealer: Boolean,
    @SerializedName("real_estate_agency") val realEstateAgency: Boolean,
    @SerializedName("tags") val tags: List<String>
)

data class InstallmentsDto(
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("amount") val amount: Double,
    @SerializedName("rate") val rate: Double,
    @SerializedName("currency_id") val currencyId: String
)

data class ShippingDto(
    @SerializedName("free_shipping") val freeShipping: Boolean,
    @SerializedName("mode") val mode: String,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("logistic_type") val logisticType: String,
    @SerializedName("store_pick_up") val storePickUp: Boolean,
    @SerializedName("state") val state: StateDto?,
    @SerializedName("city") val city: CityDto?,
    @SerializedName("latitude") val latitude: String?,
    @SerializedName("longitude") val longitude: String?
)

data class AttributeDto(
    @SerializedName("name") val name: String,
    @SerializedName("value_id") val valueId: String?,
    @SerializedName("value_name") val valueName: String,
    @SerializedName("value_struct") val valueStruct: Any?,
    @SerializedName("attribute_group_id") val attributeGroupId: String,
    @SerializedName("attribute_group_name") val attributeGroupName: String,
    @SerializedName("source") val source: Int,
    @SerializedName("id") val id: String
)

data class StateDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?
)

data class CityDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?
)