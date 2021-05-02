package com.afinaufal.androiddasar.tugasretrofit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val id:Int,
    val first_name:String,
    val last_name:String,
    val email:String,
    val createdAt:String,
    val updatedAt:String
):Parcelable
