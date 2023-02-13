package com.example.matches.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private val client = OkHttpClient
        .Builder()
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://app.sportdataapi.com/api/v1/soccer/") // change this IP for testing by your actual machine IP
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build()

     val apiservice = retrofit.create(ApiService::class.java)

}

