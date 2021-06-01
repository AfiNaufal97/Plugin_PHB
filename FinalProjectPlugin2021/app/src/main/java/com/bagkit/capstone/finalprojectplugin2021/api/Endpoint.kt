package com.bagkit.capstone.finalprojectplugin2021.api

import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.DataApi
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.DataBarang
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.MultipleData
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.SingleData
import retrofit2.Call
import retrofit2.http.*

interface Endpoint {

    @FormUrlEncoded
    @POST("auth/sign-up")
    fun registerUser(
        @Field("name")name:String,
        @Field("username")username:String,
        @Field("email")email:String,
        @Field("password")password:String
    ): Call<SingleData<DataApi>>


    @FormUrlEncoded
    @POST("auth/sign-in")
    fun loginUser(
        @Field("username")username:String,
        @Field("password")password:String
    ): Call<SingleData<DataApi>>


    @GET("barang")
    fun getAllBarang(): Call<MultipleData<DataBarang>>

    @FormUrlEncoded
    @POST("barang/")
    fun addBarang(
        @Field("nama")nama:String,
        @Field("kode")kode:Int
    ): Call<SingleData<DataBarang>>


    @GET("barang/{id}")
    fun detailBarang(
        @Path("id") id:Int
    ):Call<MultipleData<DataBarang>>

    @FormUrlEncoded
    @PUT("barang/{id}")
    fun editBarang(
        @Path("id") id:Int,
        @Field("nama")nama:String,
        @Field("kode")kode:String
    ):Call<SingleData<DataBarang>>

    @DELETE("barang/{id}")
    fun deleteBarang(
        @Path("id")id:Int
    ):Call<Void>




}