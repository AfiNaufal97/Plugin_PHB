package com.bagkit.capstone.finalprojectplugin2021.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bagkit.capstone.finalprojectplugin2021.R
import com.bagkit.capstone.finalprojectplugin2021.adapter.AdapterViewPagger
import com.bagkit.capstone.finalprojectplugin2021.databinding.AuthActivityBinding
import com.bagkit.capstone.finalprojectplugin2021.databinding.HomeActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

class AuthActivity:AppCompatActivity(){

    private lateinit var binding:AuthActivityBinding

    companion object{
        private val TAB_TITLE = intArrayOf(
            R.string.login,
            R.string.register
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AuthActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPagger()

    }

    private fun setViewPagger() {
        val vp = binding.vpHome
        val adapterVp = AdapterViewPagger(this)
        val tbLayout = binding.tabLayout
        vp.adapter = adapterVp
        TabLayoutMediator(tbLayout, vp){
            tab, position -> tab.text = resources.getString(TAB_TITLE[position])
        }.attach()
    }
}