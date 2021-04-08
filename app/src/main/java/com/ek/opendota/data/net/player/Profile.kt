package com.ek.opendota.data.net.player

import com.google.gson.annotations.SerializedName

data class Profile (
    @SerializedName("account_id") val account_id : Int? = null,
    @SerializedName("personaname") val personaname : String? = null,
    @SerializedName("name") val name : String? = null,
    @SerializedName("plus") val plus : Boolean? = null,
    @SerializedName("cheese") val cheese : Int? = null,
    @SerializedName("steamid") val steamid : String? = null,
    @SerializedName("avatar") val avatar : String? = null,
    @SerializedName("avatarmedium") val avatarmedium : String? = null,
    @SerializedName("avatarfull") val avatarfull : String? = null,
    @SerializedName("profileurl") val profileurl : String? = null,
    @SerializedName("last_login") val last_login : String? = null,
    @SerializedName("loccountrycode") val loccountrycode : String? = null,
    @SerializedName("is_contributor") val is_contributor : Boolean? = null
)