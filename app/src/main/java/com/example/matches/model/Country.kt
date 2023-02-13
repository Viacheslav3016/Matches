package com.example.matches.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country_id")
    val id:Int,
    @SerializedName("name")
    val name:String
)