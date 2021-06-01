package com.bagkit.capstone.finalprojectplugin2021.api.modelapi

data class MultipleData<T>(
    var msg:String,
    var status:Int,
    var data:List<T>
)