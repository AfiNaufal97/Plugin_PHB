package com.afinaufal.plugin.tugasweek10.model

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Data: RealmObject() {
    // table data
    private var id:Int? = null
    private var nama:String? = null
    private var email:String? = null
    private var keterangan:String? = null

    // setter dan getter

    // setData
    fun setId(masukan:Int?){
        if(id == null ){
            id = masukan
        }else{
            id = id!!+1
        }
    }


    fun setNama(nama:String){
        this.nama = nama
    }

    fun setEmail(email:String){
        this.email = email
    }

    fun setKeterangan(keterangan:String){
        this.keterangan = keterangan
    }


    // getData

    fun getId():Int?{
        return id
    }

    fun getNama():String?{
        return nama
    }

    fun getEmail():String?{
        return email
    }

    fun getKeterangan():String? {
        return keterangan
    }

}