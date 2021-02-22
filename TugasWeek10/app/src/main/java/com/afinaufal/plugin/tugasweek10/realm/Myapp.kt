package com.afinaufal.plugin.tugasweek10.realm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class Myapp:Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("myrealm.App").build()
        Realm.setDefaultConfiguration(config)
    }

}