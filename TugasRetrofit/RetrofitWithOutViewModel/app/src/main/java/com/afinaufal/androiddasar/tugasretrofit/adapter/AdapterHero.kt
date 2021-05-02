package com.afinaufal.androiddasar.tugasretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.androiddasar.tugasretrofit.databinding.ListAllHeroBinding
import com.afinaufal.androiddasar.tugasretrofit.model.Data

class AdapterHero(val data:List<Data>):RecyclerView.Adapter<AdapterHero.HeroViewHolder>() {
    class HeroViewHolder(val binding:ListAllHeroBinding):RecyclerView.ViewHolder(binding.root)

    lateinit var setOnClickListener:OnItemHeroClickListener

    interface OnItemHeroClickListener {
        fun clickItem(data:Data)
    }

    fun clickItemHero(setOnClickListener:OnItemHeroClickListener){
        this.setOnClickListener = setOnClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(ListAllHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
       val itemData = data[position]
        holder.binding.apply {
            tvName.text = itemData.first_name
        }
        holder.itemView.setOnClickListener {
            setOnClickListener.clickItem(itemData)
        }
    }

    override fun getItemCount(): Int {
       return data.size
    }
}