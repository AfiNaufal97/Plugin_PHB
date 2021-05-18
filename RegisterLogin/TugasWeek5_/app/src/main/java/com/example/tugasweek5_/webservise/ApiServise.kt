package com.example.tugasweek5_.webservise

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiServise {
    companion object{
        private var retrofit: Retrofit? = null
        private var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        private fun getClient(): Retrofit {
            return if(retrofit == null){
                retrofit = Retrofit.Builder().baseUrl(Constant.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()).build()
                retrofit!!
            }else{
                retrofit!!
            }
        }

        fun ApiEndpoint():ApiEndpoint = getClient().create(ApiEndpoint::class.java)
    }
}

class Constant{
    companion object{
        const val BASE_URL = "https://restfullbooks.herokuapp.com/ "

        fun setToken(context: Context, token:String){
            val sharedPreferences = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            sharedPreferences.edit().apply{
                putString("TOKEN", token)
                apply()
            }
        }


        fun getToken(context: Context):String{
            val sharepref = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            val token  = sharepref.getString("TOKEN", "UNDEFINED")
            return token!!
        }

        fun clearToken(context: Context){
            val sharepref = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            sharepref.edit().clear().apply()
        }

    }
}