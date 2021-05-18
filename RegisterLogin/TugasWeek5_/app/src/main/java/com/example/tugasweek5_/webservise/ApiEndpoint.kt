package com.example.tugasweek5_.webservise

import com.example.tugasweek5_.model.User
import com.example.tugasweek5_.response.SingleResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiEndpoint {
    @FormUrlEncoded
    @POST("auth/sign-up")
    fun resgister(
        @Field("username")username:String,
        @Field("email")email:String,
        @Field("password")password:String,
    ): Call<SingleResponse<User>>

    @FormUrlEncoded
    @POST("auth/sign-in")
    fun signin(
        @Field("email")email:String,
        @Field("password")password: String
    ): Call<SingleResponse<User>>
}