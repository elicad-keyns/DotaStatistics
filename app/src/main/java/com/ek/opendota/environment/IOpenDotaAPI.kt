package com.ek.opendota.environment

import com.ek.opendota.data.common.OPEN_DOTA_BASE_URL
import com.ek.opendota.data.net.matches.Match
import com.ek.opendota.data.net.player.Player
import com.ek.opendota.data.net.wl.WL
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IOpenDotaAPI {
    @GET(OPEN_DOTA_BASE_URL + "players/{accountId}")
    fun getPlayer(@Path("accountId") accountId: String?): Call<Player>

    @GET(OPEN_DOTA_BASE_URL + "players/{accountId}/matches")
    fun getMatches(@Path("accountId") accountId: String?): Call<Match>

    @GET(OPEN_DOTA_BASE_URL + "players/{accountId}/matches")
    fun getMatchesByLimit(
        @Path("accountId") accountId: String?,
        @Query("limit") limit: Int?
    ): Call<List<Match>>

    @GET(OPEN_DOTA_BASE_URL + "players/{accountId}/wl")
    fun getPlayerWL(@Path("accountId") accountId: String?): Call<WL>
}