package com.bagkit.capstone.finalprojectplugin2021.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bagkit.capstone.finalprojectplugin2021.api.ServiceApi
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.DataBarang
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.MultipleData
import com.bagkit.capstone.finalprojectplugin2021.databinding.ActivityDetailBarangBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailBarangActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBarangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBarangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", 0)
        setApi(id)
    }

    private fun setApi(intent: Int) {
        ServiceApi.api().detailBarang(intent).enqueue(object: Callback<MultipleData<DataBarang>>{
            override fun onResponse(call: Call<MultipleData<DataBarang>>, response: Response<MultipleData<DataBarang>>) {
                if(response.isSuccessful){
                    val body = response.body()!!.data
                    setView(body)
                }
            }

            override fun onFailure(call: Call<MultipleData<DataBarang>>, t: Throwable) {
                Toast.makeText(this@DetailBarangActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setView(data: List<DataBarang>) {
        val nameBarang = binding.tvNamaBarang
        val kodeBarang = binding.tvKodeBarang
        nameBarang.text = data[0].nama
        kodeBarang.text = data[0].kode.toString()

        setDeleteBarang(data[0].id)
        binding.btnEditBarang.setOnClickListener {
            startActivity(Intent(this, AddEditActivity::class.java)
                .putExtra("id", data[0].id)
                .putExtra("nama", data[0].nama)
                .putExtra("kode", data[0].kode)
                .putExtra("OPTIONS", 2))
        }
    }

    private fun setDeleteBarang(id:Int){
        binding.btnDeleteBarang.setOnClickListener {
            ServiceApi.api().deleteBarang(id).enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                   if(response.isSuccessful){
                       startActivity(Intent(this@DetailBarangActivity, HomeActivity::class.java))
                   }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@DetailBarangActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}