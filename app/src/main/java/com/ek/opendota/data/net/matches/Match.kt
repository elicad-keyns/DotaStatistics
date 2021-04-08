package com.ek.opendota.data.net.matches

data class Match(
    val match_id : Long,
    val player_slot : Int,
    val radiant_win : Boolean,
    val duration : Int,
    val game_mode : Int,
    val lobby_type : Int,
    val hero_id : Int,
    val start_time : Int,
    val version : String,
    val kills : Int,
    val deaths : Int,
    val assists : Int,
    val skill : String,
    val leaver_status : Int,
    val party_size : String
)
