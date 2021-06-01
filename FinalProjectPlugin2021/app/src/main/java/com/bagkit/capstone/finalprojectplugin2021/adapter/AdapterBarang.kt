package com.bagkit.capstone.finalprojectplugin2021.adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.DataBarang
import com.bagkit.capstone.finalprojectplugin2021.databinding.ListBarangBinding

class AdapterBarang(val data:List<DataBarang>):RecyclerView.Adapter<AdapterBarang.ViewHolderBarang>() {

    lateinit var onClickBarang:OnClickBarang

    interface OnClickBarang {
        fun clickBarang(data:DataBarang)
    }

    fun clickListBarang(onClickBarang: OnClickBarang){
        this.onClickBarang = onClickBarang
    }

    inner class ViewHolderBarang(val binding:ListBarangBinding ):RecyclerView.ViewHolder(binding.root) {
        fun bind(dataList: DataBarang) {
            binding.tvKodeBarangList.text = dataList.kode.toString()
            binding.tvNamaBarangList.text = dataList.nama
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBarang {
       return ViewHolderBarang(ListBarangBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderBarang, position: Int) {
        val dataList = data[position]
        holder.bind(dataList)
        holder.itemView.setOnClickListener {
            onClickBarang.clickBarang(dataList)
        }
    }

    override fun getItemCount() = data.size


}