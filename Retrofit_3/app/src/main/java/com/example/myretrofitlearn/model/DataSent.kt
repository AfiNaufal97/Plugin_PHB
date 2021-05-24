package com.example.myretrofitlearn.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataSent(
    val id:Int,
    val firtsName:String,
    val lastName:String,
    val email:String
):Parcelable
