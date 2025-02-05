package com.ingeacev.mymeliaplication.commons.data.model

import com.google.gson.annotations.SerializedName


data class PdpTracking(

    @SerializedName("group") var group: Boolean? = null,
    @SerializedName("product_info") var productInfo: ArrayList<String> = arrayListOf()

)