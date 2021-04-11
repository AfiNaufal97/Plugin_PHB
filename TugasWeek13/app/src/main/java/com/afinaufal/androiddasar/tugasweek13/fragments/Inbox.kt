package com.afinaufal.androiddasar.tugasweek13.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afinaufal.androiddasar.tugasweek13.databinding.InboxFragmentBinding

class Inbox:Fragment() {

    companion object{
        val PENGIRIM = "pengirim"
        val ISI = "isi"
    }

    private var _binding: InboxFragmentBinding? = null
    val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = InboxFragmentBinding.inflate(layoutInflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}