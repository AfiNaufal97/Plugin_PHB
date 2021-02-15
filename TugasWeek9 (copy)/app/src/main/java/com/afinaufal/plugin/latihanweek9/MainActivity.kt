package com.afinaufal.plugin.latihanweek9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.afinaufal.plugin.latihanweek9.adapter.AdapterData
import com.afinaufal.plugin.latihanweek9.databinding.ActivityMainBinding
import com.afinaufal.plugin.latihanweek9.model.User
import io.realm.Realm
import io.realm.exceptions.RealmException

class MainActivity : AppCompatActivity() {

    private lateinit var realm:Realm
    private lateinit var binding:ActivityMainBinding
    lateinit var adapterData:AdapterData
    val lm = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addData()
        initView()
    }

    fun addData(){
        binding.btnAdd.setOnClickListener {
            realm.beginTransaction()
            try {
                var user = realm.createObject(User::class.java)
                user.setNama(binding.setNama.text.toString())
                user.setEmail(binding.setEmail.text.toString())

//                binding.tvResult.text = "Nama : " + user.getNama() + " \nemail : " + user.getEmail()
                realm.commitTransaction()

                Toast.makeText(this, "Berhasil di tambahkan", Toast.LENGTH_SHORT).show()
            }catch (e:RealmException){
                Toast.makeText(this, "Ada error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun initView(){
        binding.rvData.layoutManager = lm
        adapterData = AdapterData(this@MainActivity)
        binding.rvData.adapter = adapterData
        
        realm = Realm.getDefaultInstance()
        realm.where(User::class.java).findAll().let {
            adapterData.setData(it)
        }
    }
}