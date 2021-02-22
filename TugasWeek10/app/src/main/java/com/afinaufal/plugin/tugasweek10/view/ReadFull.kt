package com.afinaufal.plugin.tugasweek10.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afinaufal.plugin.tugasweek10.MainActivity
import com.afinaufal.plugin.tugasweek10.adapter.AdapterHome
import com.afinaufal.plugin.tugasweek10.databinding.ActivityAddDataBinding
import com.afinaufal.plugin.tugasweek10.databinding.ActivityReadFullBinding
import com.afinaufal.plugin.tugasweek10.model.Data
import io.realm.Realm
import io.realm.exceptions.RealmException

class ReadFull : AppCompatActivity() {

    private lateinit var binding: ActivityReadFullBinding
    private lateinit var realm: Realm
    private lateinit var adapterHome:AdapterHome
    var email:String? = null
    var nama:String?= null
    var ket:String?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadFullBinding.inflate(layoutInflater)
        setContentView(binding.root)
        realm = Realm.getDefaultInstance()
        nama = intent.getStringExtra("nama")
        email = intent.getStringExtra("email")
        ket = intent.getStringExtra("keterangan")
        deleteData()
        updateData()
    }

    fun updateData(){
        binding.tvNamaReadFull.text = nama
        binding.tvEmailReadFull.text = email
        binding.tvKeteranganReadFull.text = ket
        binding.btnUpdateData.setOnClickListener {
            startActivity(Intent(Intent(this, AddData::class.java))
                    .putExtra("nama", nama)
                    .putExtra("email", email)
                    .putExtra("ket", ket)
            )
        }
    }

    fun deleteData(){
        binding.btnDeleteData.setOnClickListener {
            realm.beginTransaction()
            realm.where(Data::class.java).equalTo("email", binding.tvEmailReadFull.text.toString()).findFirst().let {
                it!!.deleteFromRealm()
            }
            realm.commitTransaction()
            startActivity(Intent(Intent(this, MainActivity::class.java)))
        }
    }
}