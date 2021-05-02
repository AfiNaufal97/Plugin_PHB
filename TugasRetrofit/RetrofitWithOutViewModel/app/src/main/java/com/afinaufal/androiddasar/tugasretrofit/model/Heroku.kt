package com.afinaufal.androiddasar.tugasretrofit.model

data class Heroku(
    val message:String,
    val status:Int,
    val data:ArrayList<Data>
)