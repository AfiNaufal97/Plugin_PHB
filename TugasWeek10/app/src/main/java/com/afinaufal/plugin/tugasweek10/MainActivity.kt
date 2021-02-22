package com.afinaufal.plugin.tugasweek10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.plugin.tugasweek10.adapter.AdapterHome
import com.afinaufal.plugin.tugasweek10.databinding.ActivityAddDataBinding
import com.afinaufal.plugin.tugasweek10.databinding.ActivityMainBinding
import com.afinaufal.plugin.tugasweek10.model.Data
import com.afinaufal.plugin.tugasweek10.view.AddData
import com.afinaufal.plugin.tugasweek10.view.ReadFull
import io.realm.Realm

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var realm: Realm
    lateinit var rv_home: RecyclerView
    lateinit var data: Data
    lateinit var adapterHome:AdapterHome
    val linearLayout = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        addButtonFunction()
    }

    private fun addButtonFunction(){
        binding.fltAdd.setOnClickListener {
            startActivity(Intent(Intent(this, AddData::class.java)))
        }
    }


    private fun init(){
        realm = Realm.getDefaultInstance()

        binding.rvHome.layoutManager = linearLayout
        adapterHome = AdapterHome(mutableListOf(), object:AdapterHome.OnItemClickListener{
            override fun clickEffect(data: Data) {
                startActivity(Intent(Intent(applicationContext, ReadFull::class.java))
                    .putExtra("nama", data.getNama().toString())
                    .putExtra("email", data.getEmail().toString())
                    .putExtra("keterangan", data.getKeterangan())
                )
            }

        })
        binding.rvHome.adapter = adapterHome
        getData()
    }


    private fun getData(){
        realm.where(Data::class.java).findAll().let {
            adapterHome.setData(it)
        }
    }


}