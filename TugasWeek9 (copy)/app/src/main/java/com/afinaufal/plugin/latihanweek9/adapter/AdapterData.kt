package com.afinaufal.plugin.latihanweek9.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.plugin.latihanweek9.databinding.ItemDataBinding
import com.afinaufal.plugin.latihanweek9.model.User

class AdapterData(val context:Context):RecyclerView.Adapter<AdapterData.ViewData>(){

    val data:MutableList<User> = mutableListOf()

    inner class ViewData(val binding:ItemDataBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        return ViewData(ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.binding.itemNama.text = data[position].getNama()
        holder.binding.itemEmail.text = data[position].getEmail()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(dataBaru:List<User>){
        data.clear()
        data.addAll(dataBaru)
        notifyDataSetChanged()
    }

}