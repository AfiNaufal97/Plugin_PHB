package com.afinaufal.plugin.tugasweek9.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.mongodb.User

class AdapterUserData(val userData:ArrayList<User>):RecyclerView.Adapter<AdapterUserData.DataUser>(){
    inner class DataUser(val binding:DataUser):RecyclerView.ViewHolder() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterUserData.DataUser {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AdapterUserData.DataUser, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}