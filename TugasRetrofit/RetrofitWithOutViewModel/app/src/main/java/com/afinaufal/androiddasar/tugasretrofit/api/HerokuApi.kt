package com.afinaufal.androiddasar.tugasretrofit.api

import com.afinaufal.androiddasar.tugasretrofit.model.Data
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface HerokuApi {

    @GET("person")
    fun getAllHero():Call<MultipleResponse<Data>>

    @GET("person/{id}")
    fun getDeailHero(
        @Path("id") id:Int
    ):Call<SingleResponse<Data>>

    @DELETE("person/{id}")
    fun deleteHero(
            @Path("id")id:Int
    ):Call<Void>
}

data class SingleResponse<T>(
        val message:String,
        val status:Int,
        val data:T
)

data class MultipleResponse<T>(
        val message:String,
        val status:Int,
        val data:List<T>
)