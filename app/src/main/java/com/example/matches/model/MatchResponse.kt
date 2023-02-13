package com.example.matches.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

data class MatchResponse(
    @SerializedName("data")
    val list: List<MatchItem>
)
