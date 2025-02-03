package com.ingeacev.mymeliaplication.data.remote.model

import com.google.gson.annotations.SerializedName


data class AvailableCurrencies(

    @SerializedName("currencies") var currencies: ArrayList<Currencies> = arrayListOf(),
    @SerializedName("conversions") var conversions: Conversions? = Conversions()

)