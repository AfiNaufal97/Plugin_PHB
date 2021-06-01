package com.bagkit.capstone.finalprojectplugin2021.api

import com.bagkit.capstone.finalprojectplugin2021.api.constanta.Constanta.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceApi {
    companion object{
        private var myRetrofit: Retrofit? = null
        private var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        private fun getClientApi():Retrofit{
            return if(myRetrofit == null){
                myRetrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                myRetrofit!!
            }else{
                myRetrofit!!
            }
        }

        fun api():Endpoint = getClientApi().create(Endpoint::class.java)

    }
}