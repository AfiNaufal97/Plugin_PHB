package com.example.retrofitloginregister.model

data class SingleResponse<T>(
    var msg:String,
    var status:Int,
    var data:T
)