package com.afinaufal.androiddasar.tugasweek13.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.afinaufal.androiddasar.tugasweek13.Data
import com.afinaufal.androiddasar.tugasweek13.ListUsers
import com.afinaufal.androiddasar.tugasweek13.R
import com.afinaufal.androiddasar.tugasweek13.adapter.AdapaterPesan
import com.afinaufal.androiddasar.tugasweek13.databinding.FragmentPesanBinding

class FragmentPesan: Fragment() {

    private var _binding:FragmentPesanBinding? = null
    val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPesanBinding.inflate(layoutInflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val isiPesan = ListUsers.dataLengkap
        val adapterPesan = AdapaterPesan(isiPesan)
        binding!!.rvPesan.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = adapterPesan
            adapterPesan.setClickItem(object : AdapaterPesan.SetOnItemClickListener {
                override fun clickPesan(masukanData: Data) {
                    Toast.makeText(context, "Anda menekan ${masukanData.pesan}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}