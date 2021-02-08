package com.afinaufal.plugin.tugasweek8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.afinaufal.plugin.tugasweek8.adapter.AdapterView
import com.afinaufal.plugin.tugasweek8.databinding.ActivityMainBinding
import com.afinaufal.plugin.tugasweek8.model.DataView

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dataView = mutableListOf<DataView>(
                DataView(R.drawable.android5, "Android Lolipop", "Android Versi Kelima dari android yang ada, dan pengembangan dari versi 4"),
                DataView(R.drawable.android8, "Android Oreo", "Android Versi Kedelapan dari android yang ada, dan pengembangan dari versi 7"),
                DataView(R.drawable.android9, "Android Pie", "Android Versi Kesembilan dari android yang ada, dan pengembangan dari versi 8")
        )

        val adapaterData = AdapterView(dataView as ArrayList<DataView>)

        binding.rvTampilan.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapaterData
        }
    }
}