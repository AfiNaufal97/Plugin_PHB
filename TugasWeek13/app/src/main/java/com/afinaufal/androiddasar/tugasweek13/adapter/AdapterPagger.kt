package com.afinaufal.androiddasar.tugasweek13.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.afinaufal.androiddasar.tugasweek13.fragments.FragmentKontak
import com.afinaufal.androiddasar.tugasweek13.fragments.FragmentPesan
import com.afinaufal.androiddasar.tugasweek13.fragments.FragmentStatus
import com.afinaufal.androiddasar.tugasweek13.fragments.Inbox

class AdapterPagger(fragment:Fragment):FragmentStateAdapter(fragment) {



    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragemnt:Fragment? = null
        when(position){
            0 -> fragemnt = FragmentPesan()
            1 -> fragemnt = FragmentKontak()
            2 -> fragemnt = FragmentStatus()
        }
        return fragemnt as Fragment
    }

}