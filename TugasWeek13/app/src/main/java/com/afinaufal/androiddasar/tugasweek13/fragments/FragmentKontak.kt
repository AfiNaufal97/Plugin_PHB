package com.afinaufal.androiddasar.tugasweek13.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.afinaufal.androiddasar.tugasweek13.ListUsers
import com.afinaufal.androiddasar.tugasweek13.adapter.AdapaterKontak
import com.afinaufal.androiddasar.tugasweek13.adapter.AdapaterPesan
import com.afinaufal.androiddasar.tugasweek13.databinding.FragmentKontakBinding

class FragmentKontak: Fragment() {
    private var _binding: FragmentKontakBinding? = null
    val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentKontakBinding.inflate(layoutInflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val isiPesan = ListUsers.dataLengkap
        val adapterPesan = AdapaterKontak(isiPesan)
        binding!!.rvKontak.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = adapterPesan
        }
    }
}