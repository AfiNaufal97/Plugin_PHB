package com.bagkit.capstone.finalprojectplugin2021.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bagkit.capstone.finalprojectplugin2021.R
import com.bagkit.capstone.finalprojectplugin2021.api.constanta.Constanta
import com.bagkit.capstone.finalprojectplugin2021.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMyProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewProfile()
        setLogout()
    }

    private fun setLogout() {
        binding.btnLogout.setOnClickListener {
            Constanta.deleteToken(this)
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
    }

    private fun setViewProfile() {
        val nameProfile = binding.tvNameProfile
        val usernameProfile = binding.tvUsernameProfile
        val emailProfile = binding.tvEmailProfile

        nameProfile.text = Constanta.getNameUser(this)
        usernameProfile.text = Constanta.getUsername(this)
        emailProfile.text =  Constanta.getEmailUser(this)
    }
}