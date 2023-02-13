package com.example.matches.model

import com.google.gson.annotations.SerializedName

data class HomeTeam(
    @SerializedName("team_id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("logo")
    val logo:String,
    @SerializedName("country")
    val country:Country
)