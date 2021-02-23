package com.afinaufal.plugin.latihanweek11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // fragment object
    lateinit var homeFragment: HomeFragment
    lateinit var favoriteFragment: FavoriteFragment
    lateinit var settingFragment: SettingFragment
    lateinit var aboutFragment: AboutFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create variable innitialisai bottom nav frame layput
        var bottom_nav = findViewById<BottomNavigationView>(R.id.btn_nav_menu)
        var frame =  findViewById<FrameLayout>(R.id.frame_layout)


        homeFragment = HomeFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

        bottom_nav.setOnNavigationItemSelectedListener {
            item ->
            when(item.itemId){
                R.id.home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

                R.id.setting -> {
                    settingFragment = SettingFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, settingFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.favorit -> {
                    favoriteFragment = FavoriteFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, favoriteFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.about -> {
                    aboutFragment = AboutFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, aboutFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }



            true
        }
    }
}