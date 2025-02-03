package com.ingeacev.mymeliaplication.data.remote.model

import com.google.gson.annotations.SerializedName


data class Conversions (

  @SerializedName("ars_usd" ) var arsUsd : Double? = null,
  @SerializedName("usd_ars" ) var usdArs : Int?    = null

)