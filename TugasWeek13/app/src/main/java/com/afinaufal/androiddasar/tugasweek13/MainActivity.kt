package com.afinaufal.androiddasar.tugasweek13

import android.app.Dialog
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.afinaufal.androiddasar.tugasweek13.adapter.AdapterPagger
import com.afinaufal.androiddasar.tugasweek13.databinding.ActivityMainBinding
import com.afinaufal.androiddasar.tugasweek13.fragments.FragmentPesan
import com.afinaufal.androiddasar.tugasweek13.fragments.Home
import com.afinaufal.androiddasar.tugasweek13.fragments.Inbox
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding:ActivityMainBinding
    lateinit var toogle:ActionBarDrawerToggle
    lateinit var home:Home
    lateinit var inbox: Inbox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_home, Home())
            commit()
        }

        home = Home()
        inbox = Inbox()

        binding.btmNav.setOnNavigationItemSelectedListener(this)
    }

    private fun controlBottomNav(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_home, fragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun drawerLayout() {
        val drawer = binding.drawerLayout
        toogle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navDrawer.setNavigationItemSelectedListener(this)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.btn_show_profile ->{
                val tampilkan = AlertDialog.Builder(this).apply {
                   setView(R.layout.tampilkan_profile)
                    setNegativeButton("close"){
                        dialog,_ -> dialog.dismiss()
                    }
                }
                tampilkan.show()
            }
        }
        if(toogle.onOptionsItemSelected(item)){
            true
        }

        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.btn_delete -> Toast.makeText(applicationContext, "Anda menekan${item.title}", Toast.LENGTH_SHORT).show()
            R.id.btn_save -> Toast.makeText(this, "Anda menekan${item.title}", Toast.LENGTH_SHORT).show()
            R.id.btn_night -> Toast.makeText(this, "Anda menekan${item.title}", Toast.LENGTH_SHORT).show()
            R.id.btn_version -> Toast.makeText(this, "Anda menekan${item.title}", Toast.LENGTH_SHORT).show()
            R.id.btn_home -> controlBottomNav(home)
            R.id.btn_inbox -> controlBottomNav(inbox)
        }
        return true
    }

}