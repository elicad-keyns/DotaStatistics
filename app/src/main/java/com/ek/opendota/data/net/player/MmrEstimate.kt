package com.ek.opendota.data.net.player

import com.google.gson.annotations.SerializedName

data class MmrEstimate (
    @SerializedName("estimate") val estimate : Int? = null,
    @SerializedName("stdDev") val stdDev : Int? = null,
    @SerializedName("n") val n : Int? = null
)