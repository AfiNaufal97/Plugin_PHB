package com.afinaufal.plugin.tugasweek7

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.parsing_data.*
import kotlinx.android.synthetic.main.parsing_data.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        github()
        exitApp()
        parsingData()
        profile()
    }


    private fun github(){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://github.com/AfiNaufal97/Plugin_PHB"))
        iv_github.setOnClickListener {
            startActivity(intent)
        }

        tv_github.setOnClickListener {
            startActivity(intent)
        }

        cv_github.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun exitApp(){
        iv_exit.setOnClickListener {
            finish()
        }

        tv_exit.setOnClickListener {
            finish()
        }

        cv_exit.setOnClickListener {
            finish()
        }
    }

    private fun parsingData(){
        iv_parsing.setOnClickListener {
            logicParsing()
        }

        tv_parsing.setOnClickListener {
            logicParsing()
        }

        cv_parsing.setOnClickListener {
            logicParsing()
        }
    }

    private fun profile(){
        iv_profile_saya.setOnClickListener {
            startActivity(Intent(this@MainActivity, Profile::class.java))
        }

        tv_profile.setOnClickListener {
            startActivity(Intent(this@MainActivity, Profile::class.java))
        }

       cv_profile.setOnClickListener {
            startActivity(Intent(this@MainActivity, Profile::class.java))
        }
    }

    private fun logicParsing() {
        val viewTampilan = LayoutInflater.from(this@MainActivity)
        val isiTampilan = viewTampilan.inflate(R.layout.parsing_data, null)

        val parsingData = AlertDialog.Builder(this)
            .setView(isiTampilan)
        val tampilkanAlert = parsingData.show()

        isiTampilan.btn_Parsing.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, DataParsing::class.java)
                    .putExtra("nama", isiTampilan.edt_nama.text.toString())
                    .putExtra("semester", isiTampilan.edt_semester.text.toString())
                    .putExtra("divisi", isiTampilan.edt_divisi.text.toString())
            )
            finish()
        }

        isiTampilan.btn_close.setOnClickListener {
           tampilkanAlert.dismiss()
        }
    }
}