package com.example.retrofitloginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitloginregister.api.Constanta
import com.example.retrofitloginregister.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logout()
    }

    private fun logout() {
        binding.btnLogout.setOnClickListener {
            Constanta.deleteToken(this)
            startActivity(Intent(this,FormLogin::class.java ))
            finish()
        }
    }
}