package com.ingeacev.mymeliaplication.commons.data.model

import com.google.gson.annotations.SerializedName


data class Seller(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("nickname") var nickname: String? = null

)