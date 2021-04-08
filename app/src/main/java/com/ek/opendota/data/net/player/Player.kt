package com.ek.opendota.data.net.player

import com.google.gson.annotations.SerializedName

data class Player (
    @SerializedName("tracked_until") val tracked_until : String? = null,
    @SerializedName("solo_competitive_rank") val solo_competitive_rank : String? = null,
    @SerializedName("competitive_rank") val competitive_rank : String? = null,
    @SerializedName("rank_tier") val rank_tier : Int? = null,
    @SerializedName("leaderboard_rank") val leaderboard_rank : Int? = null,
    @SerializedName("mmr_estimate") val mmr_estimate : MmrEstimate? = null,
    @SerializedName("profile") val profile : Profile? = null
) {
    companion object {}
}