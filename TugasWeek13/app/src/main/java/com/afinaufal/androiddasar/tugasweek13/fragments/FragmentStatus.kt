package com.afinaufal.androiddasar.tugasweek13.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afinaufal.androiddasar.tugasweek13.databinding.FragmentStatusBinding

class FragmentStatus: Fragment(){
    private var _binding: FragmentStatusBinding? = null
    val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentStatusBinding.inflate(layoutInflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}