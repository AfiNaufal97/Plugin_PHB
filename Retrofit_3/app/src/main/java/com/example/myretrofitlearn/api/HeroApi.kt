package com.example.myretrofitlearn.api

import com.example.myretrofitlearn.model.Data
import retrofit2.Call
import retrofit2.http.*

interface HeroApi {
    @GET("person")
    fun getAllHero(): Call<MultipleOption<Data>>

    @GET("person/{id}")
    fun detailHero(
        @Path("id") id:Int
    ):Call<SingleOption<Data>>

    @FormUrlEncoded
    @PUT("person/{id}")
    fun editHero(
        @Path("id") id:Int,
        @Field("first_name") first_name:String,
        @Field("last_name") last_name:String,
        @Field("email") email:String
    ):Call<SingleOption<Data>>

    @FormUrlEncoded
    @POST("person")
    fun addHero(
        @Field("first_name") first_name:String,
        @Field("last_name") last_name:String,
        @Field("email") email:String
    ):Call<SingleOption<Data>>

    @DELETE("person/{id}")
    fun deleteHero(
        @Path("id")id:Int
    ):Call<Void>
}

data class SingleOption<T>(
    val data :T,
    val message: String,
    val status: Int
)

data class MultipleOption<T>(
    val data :List<T>,
    val message: String,
    val status: Int
)