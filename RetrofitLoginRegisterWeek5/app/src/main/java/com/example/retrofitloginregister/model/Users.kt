package com.example.retrofitloginregister.model

data class Users(
    var id:Int,
    var name:String,
    var username:String,
    var email:String,
    var password:String,
    var token:String
)