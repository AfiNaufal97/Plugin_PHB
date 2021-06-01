package com.bagkit.capstone.finalprojectplugin2021.api.modelapi

data class SingleData<T>(
    var msg:String,
    var status:Int,
    var data:T
)
