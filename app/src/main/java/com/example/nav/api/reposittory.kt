package com.example.nav.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  networkRepository{
    private val BASE_URL ="https://fakestoreapi.com/"
    val api:ApiInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiInterface::class.java)

    }
}