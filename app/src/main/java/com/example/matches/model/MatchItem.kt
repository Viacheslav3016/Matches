package com.example.matches.model

import com.google.gson.annotations.SerializedName

data class MatchItem(
    @SerializedName("match_id")
    val match_id:Int,
    @SerializedName("status")
    val status:String,
    @SerializedName("match_start")
    val match_start:String,
    @SerializedName("home_team")
    val homeTeam: HomeTeam,
    @SerializedName("away_team")
    val awayTeam: AwayTeam
)