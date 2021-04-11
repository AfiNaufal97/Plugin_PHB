package com.afinaufal.androiddasar.tugasweek13.fragments

import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afinaufal.androiddasar.tugasweek13.R
import com.afinaufal.androiddasar.tugasweek13.adapter.AdapterPagger
import com.afinaufal.androiddasar.tugasweek13.databinding.HomeFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class Home: Fragment() {

    private var _binding:HomeFragmentBinding?= null
    val binding get() = _binding
    lateinit var adapterVp: AdapterPagger

    companion object{
        val DATA_NAME = intArrayOf(
            R.string.satu,
                R.string.dua,
                R.string.tiga
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapterVp = AdapterPagger(this)
        binding?.vpFragmentHome?.adapter = adapterVp

        TabLayoutMediator(binding!!.tbLayout, binding!!.vpFragmentHome){
            Tab, position -> Tab.text = getString(DATA_NAME[position])
        }.attach()
    }

}