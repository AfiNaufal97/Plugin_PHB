package com.afinaufal.androiddasar.sendvaluebetweenfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.afinaufal.androiddasar.sendvaluebetweenfragment.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding:ActivityMainBinding
    lateinit var fragmentHome: FragmentHome
    lateinit var fragmentDetail: FragmentDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentHome = FragmentHome()
        fragmentDetail = FragmentDetail()

        binding.btnHomeMenu.setOnClickListener(this)
        binding.btnDataMenu.setOnClickListener(this)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_home, fragmentHome)
            supportActionBar?.title = "sendData"
            commit()
        }
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_home_menu -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fl_home, fragmentHome)
                    supportActionBar?.title = "Home"
                    commit()
                }
            }
            R.id.btn_data_menu -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fl_home, fragmentDetail)
                    supportActionBar?.title = "sendData"
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }


}