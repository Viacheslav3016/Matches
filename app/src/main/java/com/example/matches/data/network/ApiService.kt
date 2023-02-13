package com.example.matches.data.network

import com.example.matches.model.MatchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
//https://app.sportdataapi.com/api/v1/soccer/matches?apikey=cfd52640-a895-11ed-b9cb-3b248b4c6969&live=true
//team_id
interface ApiService {

    @GET("matches?apikey=cfd52640-a895-11ed-b9cb-3b248b4c6969&live=true")
    fun loadMatches(num:Int):Single<MatchResponse>

}