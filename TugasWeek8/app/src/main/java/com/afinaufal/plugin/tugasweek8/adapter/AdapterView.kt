package com.afinaufal.plugin.tugasweek8.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.plugin.tugasweek8.R
import com.afinaufal.plugin.tugasweek8.databinding.TampilanViewBinding
import com.afinaufal.plugin.tugasweek8.model.DataView
import com.bumptech.glide.Glide
class AdapterView(private val data:ArrayList<DataView>):RecyclerView.Adapter<AdapterView.TampilanView>(){
    inner class TampilanView(val binding:TampilanViewBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TampilanView {
        return TampilanView(TampilanViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TampilanView, position: Int) {
        holder.binding.apply {
            tvJudul.text = data[position].judul
            tvDeskripsi.text = data[position].deskripsi
            Glide.with(holder.itemView.context)
                    .load(data[position].foto)
                    .into(holder.binding.ivView)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}