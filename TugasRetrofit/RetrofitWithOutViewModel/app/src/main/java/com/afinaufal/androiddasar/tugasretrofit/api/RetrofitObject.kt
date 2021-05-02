package com.afinaufal.androiddasar.tugasretrofit.api

import com.afinaufal.androiddasar.tugasretrofit.utility.Constanta.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    val Api by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(HerokuApi::class.java)
    }
}