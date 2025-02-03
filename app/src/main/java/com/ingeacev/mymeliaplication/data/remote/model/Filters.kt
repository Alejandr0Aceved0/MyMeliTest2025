package com.ingeacev.mymeliaplication.data.remote.model

import com.google.gson.annotations.SerializedName
import com.ingeacev.mymeliaplication.data.remote.model.Values


data class Filters(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("values") var values: ArrayList<Values> = arrayListOf()

)