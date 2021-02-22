package com.afinaufal.plugin.tugasweek10.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.plugin.tugasweek10.MainActivity
import com.afinaufal.plugin.tugasweek10.databinding.ActivityAddDataBinding
import com.afinaufal.plugin.tugasweek10.databinding.ActivityMainBinding
import com.afinaufal.plugin.tugasweek10.model.Data
import io.realm.Realm
import io.realm.exceptions.RealmException
import io.realm.mongodb.User

class AddData : AppCompatActivity() {

    lateinit var binding: ActivityAddDataBinding
    lateinit var realm:Realm
    lateinit var data:Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title ="Add Data"

        realm = Realm.getDefaultInstance()
        masukanData()
        addData()
        editData()
    }

    fun masukanData(){
        supportActionBar?.title ="Update Data"
        val namaMasukan = intent.getStringExtra("nama")
        val emailMasukan = intent.getStringExtra("email")
        val keteranganMasukan = intent.getStringExtra("ket")
        binding.edtNama.setText(namaMasukan)
        binding.edtEmail.setText(emailMasukan)
        binding.edtKeterangan.setText(keteranganMasukan)
    }

    fun addData(){
        binding.btnAddData.setOnClickListener {
            realm.beginTransaction()
            try {
                data = realm.createObject(Data::class.java)
                data.setId(1)
                data.setNama(binding.edtNama.text.toString())
                data.setEmail(binding.edtEmail.text.toString())
                data.setKeterangan(binding.edtKeterangan.text.toString())
                realm.commitTransaction()
            }catch (e:RealmException){
                println(e)
            }
            startActivity(Intent(Intent(this, MainActivity::class.java)))
            finish()
        }
    }

    fun editData(){
        binding.btnUpdateData.setOnClickListener {
            realm.beginTransaction()
            realm.where(Data::class.java).equalTo("email", binding.edtEmail.text.toString()).findFirst().let {
                it!!.setNama(binding.edtNama.text.toString())
                it!!.setKeterangan(binding.edtKeterangan.text.toString())
            }
            realm.commitTransaction()
            startActivity(Intent(Intent(this, MainActivity::class.java)))
        }
    }
}