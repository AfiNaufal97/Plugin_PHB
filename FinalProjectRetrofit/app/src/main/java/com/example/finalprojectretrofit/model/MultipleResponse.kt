package com.example.finalprojectretrofit.model

data class SingleResponse<T>(
    var message:String,
    var status:Int,
    var data:T
)