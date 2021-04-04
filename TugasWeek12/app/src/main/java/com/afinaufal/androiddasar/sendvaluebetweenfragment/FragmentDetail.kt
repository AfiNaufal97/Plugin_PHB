package com.afinaufal.androiddasar.sendvaluebetweenfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.afinaufal.androiddasar.sendvaluebetweenfragment.databinding.FragementDetailBinding

class FragmentDetail:Fragment(){

    private var _binding:FragementDetailBinding? = null
    private val binding get() = _binding
    lateinit var data:ContainerData

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragementDetailBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(arguments != null){
            binding!!.ivEmpty.visibility = View.GONE
            binding!!.lyResult.visibility = View.VISIBLE
            data = arguments?.getParcelable<ContainerData>(FragmentHome.EXTRA_DATA) as ContainerData

            binding!!.tvShowName.text = data.nama
            binding!!.tvShowAngkatan.text = data.angkatan.toString()
            binding!!.tvShowSquad.text = data.squad
            binding!!.tvShowHobiSaya.text = data.hobi
        }

    }


}