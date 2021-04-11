package com.afinaufal.androiddasar.tugasweek13.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.androiddasar.tugasweek13.Data
import com.afinaufal.androiddasar.tugasweek13.databinding.ListKontakBinding

class AdapaterKontak(val isiMasukan:ArrayList<Data>):RecyclerView.Adapter<AdapaterKontak.ViewHolderPesan>(){
    class ViewHolderPesan(val binding:ListKontakBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(isiMasukan:Data){
            binding.tvTextNama.text = isiMasukan.nama
            binding.tvTextNohp.text = isiMasukan.noHp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPesan {
        return ViewHolderPesan(ListKontakBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderPesan, position: Int) {
       holder.bind(isiMasukan[position])
    }

    override fun getItemCount(): Int {
        return isiMasukan.size
    }

}