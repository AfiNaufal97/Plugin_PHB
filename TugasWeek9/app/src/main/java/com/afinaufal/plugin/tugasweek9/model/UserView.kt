package com.afinaufal.plugin.tugasweek9.model

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
data class User:RealmObject() {

    private var id:Int? = null
    private var nama:String? = null

    private var email:String? = null


    fun setId(id:Int){
        this.id = id
    }

    fun setNama(nama:String){
        this.nama = nama
    }
    fun setEmail(email:String){
        this.email = email
    }

    fun getId():Int?{
        return id
    }

    fun getNama():String?{
        return nama
    }

    fun getEmail():String?{
        return email
    }


}