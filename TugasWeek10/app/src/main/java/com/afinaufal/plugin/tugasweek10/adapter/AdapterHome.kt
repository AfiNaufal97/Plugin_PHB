package com.afinaufal.plugin.tugasweek10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.plugin.tugasweek10.databinding.LayoutHomeBinding
import com.afinaufal.plugin.tugasweek10.model.Data

class AdapterHome(val dataMasukan:MutableList<Data>, val item:OnItemClickListener):RecyclerView.Adapter<AdapterHome.ViewData>(){
    class ViewData(val binding:LayoutHomeBinding):RecyclerView.ViewHolder(binding.root)
    interface OnItemClickListener {
        fun clickEffect(data:Data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        return ViewData(LayoutHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.binding.tvItemNamaHome.text = dataMasukan[position].getNama()
        holder.binding.tvItemEmailHome.text = dataMasukan[position].getEmail()
        holder.binding.tvItemKeteranganHome.text = dataMasukan[position].getKeterangan()
        holder.itemView.setOnClickListener {
            item.clickEffect(dataMasukan[position])
        }
    }

    override fun getItemCount() = dataMasukan.size

    fun setData(masukan:List<Data>){
        dataMasukan.clear()
        dataMasukan.addAll(masukan)
        notifyDataSetChanged()
    }
}