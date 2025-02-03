package com.ingeacev.mymeliaplication.data.remote.model

import com.google.gson.annotations.SerializedName


data class Neighborhood (

  @SerializedName("id"   ) var id   : String? = null,
  @SerializedName("name" ) var name : String? = null

)