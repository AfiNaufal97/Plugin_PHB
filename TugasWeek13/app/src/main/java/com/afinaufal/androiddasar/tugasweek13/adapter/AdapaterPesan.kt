package com.afinaufal.androiddasar.tugasweek13.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.androiddasar.tugasweek13.Data
import com.afinaufal.androiddasar.tugasweek13.databinding.ListPesanBinding

class AdapaterPesan(val isiMasukan:ArrayList<Data>):RecyclerView.Adapter<AdapaterPesan.ViewHolderPesan>(){

    lateinit var setOnItemClickListener:SetOnItemClickListener

    interface SetOnItemClickListener {
        fun clickPesan(masukanData:Data)
    }

    fun setClickItem(setOnItemClickListener: SetOnItemClickListener){
        this.setOnItemClickListener = setOnItemClickListener
    }

    inner class ViewHolderPesan(val binding:ListPesanBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(isiMasukan:Data){
            binding.tvTextNama.text = isiMasukan.nama
            binding.tvTextPesan.text = isiMasukan.pesan
            itemView.setOnClickListener{
                setOnItemClickListener.clickPesan(isiMasukan)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPesan {
        return ViewHolderPesan(ListPesanBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderPesan, position: Int) {
       holder.bind(isiMasukan[position])
    }

    override fun getItemCount(): Int {
        return isiMasukan.size
    }

}