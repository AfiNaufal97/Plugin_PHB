package com.example.myretrofitlearn.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofitlearn.databinding.ListHeroBinding
import com.example.myretrofitlearn.model.Data

class AdapterHero(val listHero:List<Data>):RecyclerView.Adapter<AdapterHero.HeroViewHolder>(){

    lateinit var clickHero:SetOnClickHero

    interface SetOnClickHero {
        fun clickList(data:Data)
    }

    @JvmName("setClickHero1")
    fun setClickHero(hero:SetOnClickHero){
        this.clickHero = hero
    }

    class HeroViewHolder(val binding:ListHeroBinding):RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(list: Data) {
            binding.tvNameHero.text = list.first_name+ " " + list.last_name
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(ListHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val list = listHero[position]
        holder.bind(list)
        holder.itemView.setOnClickListener {
            clickHero.clickList(list)
        }
    }

    override fun getItemCount() = listHero.size
}