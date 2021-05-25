package com.example.retrofitloginregister.api

import com.example.retrofitloginregister.model.SingleResponse
import com.example.retrofitloginregister.model.Users
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiEndpoint {

    @FormUrlEncoded
    @POST("auth/sign-up")
    fun SignUpUser(
    @Field("name") name:String,
    @Field("username") username:String,
    @Field("email") email:String,
    @Field("password") password:String): Call<SingleResponse<Users>>

    @FormUrlEncoded
    @POST("auth/sign-in")
    fun SignUser(
        @Field("username") username: String,
        @Field("password") password: String
    ):Call<SingleResponse<Users>>

}