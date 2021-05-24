package com.example.myretrofitlearn.api

import com.example.myretrofitlearn.constanta.Constanta.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofits {
    companion object{
        val retrofit =  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HeroApi::class.java)
    }
}