package com.afinaufal.androiddasar.tugasweek13

object ListUsers{
    val nama = arrayListOf<String>(
            "Afi",
            "Naufal",
            "Setiawan",
    )

    val nomer = arrayListOf<String>(
            "02345678910",
            "02345678911",
            "02345678912"
    )

    val pesan = arrayListOf<String>(
            "Hallo, Apa Kabar",
            "Hallo, Apa Kabar",
            "Hallo, Apa Kabar",
    )

    val dataLengkap:ArrayList<Data>
        get() {
        val dataSementara = ArrayList<Data>()
        for(i in nama.indices){
            val data = Data()
            data.nama = nama[i]
            data.noHp = nomer[i]
            data.pesan = pesan[i]
            dataSementara.addAll(listOf(data))
        }
        return dataSementara
    }
}