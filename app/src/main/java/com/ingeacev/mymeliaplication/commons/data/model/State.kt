package com.ingeacev.mymeliaplication.commons.data.model

import com.google.gson.annotations.SerializedName


data class State(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null

)