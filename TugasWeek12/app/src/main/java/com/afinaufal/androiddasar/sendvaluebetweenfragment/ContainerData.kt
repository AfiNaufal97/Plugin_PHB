package com.afinaufal.androiddasar.sendvaluebetweenfragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContainerData(
    var nama:String = "",
    var squad:String=" ",
    var angkatan:Int = 0,
    var hobi:String= " "
) : Parcelable
