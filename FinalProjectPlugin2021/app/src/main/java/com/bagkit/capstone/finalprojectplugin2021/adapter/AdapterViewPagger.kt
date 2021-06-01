package com.bagkit.capstone.finalprojectplugin2021.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bagkit.capstone.finalprojectplugin2021.ui.fragments.LoginFragment
import com.bagkit.capstone.finalprojectplugin2021.ui.fragments.RegisterFragment

class AdapterViewPagger(activity:FragmentActivity):FragmentStateAdapter(activity) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       var fragment:Fragment? = null
        when(position){
            0 -> fragment = LoginFragment()
            1 -> fragment = RegisterFragment()
        }
        return fragment as Fragment
    }
}