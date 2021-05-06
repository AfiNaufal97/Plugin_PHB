package com.afinaufal.androiddasar.tugasretrofit.api

import com.afinaufal.androiddasar.tugasretrofit.model.Data
import retrofit2.Call
import retrofit2.http.*

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

    @FormUrlEncoded
    @POST("/person")
    fun addHero(
            @Field("first_name") first_name:String,
            @Field("last_name") last_name:String,
            @Field("email") email:String
    ):Call<SingleResponse<Data>>

    @FormUrlEncoded
    @PUT("/person/{id}")
    fun editHero(
            @Path("id") id:Int,
            @Field("first_name") first_name:String,
            @Field("last_name") last_name:String,
            @Field("email") email:String
    ):Call<SingleResponse<Data>>
}

data class SingleResponse<T>(
        val message:String,
        val status:Int,
        val data:T
)

data class MultipleResponse<T>(
        val message:String,
        val status:Int,
        val data:ArrayList<T>
)