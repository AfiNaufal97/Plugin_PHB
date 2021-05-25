package com.example.retrofitloginregister.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIWithRetrofit {
    companion object{
        private var myRetrofit: Retrofit? = null
        private var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        private fun getClient():Retrofit{
            return if(myRetrofit == null){
                myRetrofit = Retrofit.Builder().baseUrl(Constanta.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                myRetrofit!!
            }else{
                myRetrofit!!
            }
        }

        fun api():ApiEndpoint = getClient().create(ApiEndpoint::class.java)
    }
}



class Constanta{
    companion object{
        const val BASE_URL = "https://apibarang.herokuapp.com/"

        fun setToken(context: Context, token:String){
            val setToken = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            setToken.edit().apply{
                putString("TOKEN", token)
                apply()
            }
        }

        fun getToken(context: Context):String{
            val sharePref = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            val token = sharePref.getString("TOKEN", "Undefined")
            return token!!
        }

        fun deleteToken(context: Context){
            val eraseToken = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            eraseToken.edit().clear().apply()
        }
    }
}