package com.afinaufal.plugin.tugasweek7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data_parsing.*

class DataParsing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_parsing)

        supportActionBar?.title = "Data Parsing"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        btn_back.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

        val namaParsing = intent.getStringExtra("nama")
        val semesterParsing = intent.getStringExtra("semester")
        val divisiParsing = intent.getStringExtra("divisi")

        val nama = "Hallo $namaParsing"
        val semester = "Dari Semester $semesterParsing"
        val divisi = "divisi $divisiParsing"

        tv_nama_parsing.text = nama
        tv_semester_parsing.text = semester
        tv_divisi_parsing.text = divisi

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}