package com.example.tugasweek5_.response

data class SingleResponse<T>(
    var msg:String,
    var status:String,
    var data :T
)