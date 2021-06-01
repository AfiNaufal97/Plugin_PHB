
package com.bagkit.capstone.finalprojectplugin2021.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bagkit.capstone.finalprojectplugin2021.R
import com.bagkit.capstone.finalprojectplugin2021.api.ServiceApi
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.DataBarang
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.MultipleData
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.SingleData
import com.bagkit.capstone.finalprojectplugin2021.databinding.ActivityAddEditBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddEditActivity : AppCompatActivity() {

    lateinit var binding:ActivityAddEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra("nama")
        val kode = intent.getIntExtra("kode", 0)
        val getData = intent.getIntExtra("OPTIONS", 1)
        setView(getData)

        binding.edtNamaBarang.setText(nama)
        binding.edtKodeBarng.setText(kode.toString())
    }

    private fun setView(data: Int) {
        when(data){
            1 -> {
                binding.btnEditBarang.visibility = View.GONE
                binding.btnAddBarang.visibility = View.VISIBLE
                addInput()
            }
            2 -> {
                binding.btnAddBarang.visibility = View.GONE
                binding.btnEditBarang.visibility = View.VISIBLE
                val idData = intent.getIntExtra("id", 0)
                setEdit(idData)
            }
        }

    }

    private fun setEdit(idData: Int) {
        binding.btnEditBarang.setOnClickListener {
            val id = idData
            val setNama = binding.edtNamaBarang.text.toString()
            val setKode = binding.edtKodeBarng.text.toString()

            menuEdit(id, setNama, setKode)
        }
    }

    private fun menuEdit(id: Int, nama: String, kode: String) {
        ServiceApi.api().editBarang(id, nama, kode).enqueue(object : Callback<SingleData<DataBarang>> {
            override fun onResponse(
                call: Call<SingleData<DataBarang>>,
                response: Response<SingleData<DataBarang>>
            ) {
               if(response.isSuccessful){
                   startActivity(Intent(this@AddEditActivity, HomeActivity::class.java))
               }
            }

            override fun onFailure(call: Call<SingleData<DataBarang>>, t: Throwable) {
                Toast(this@AddEditActivity).apply {
                    duration = Toast.LENGTH_LONG
                    view = layoutInflater.inflate(R.layout.error, findViewById(R.id.ly_error))
                    show()
                }
            }

        })
    }


    private fun addInput() {
        binding.btnAddBarang.setOnClickListener {
            val nama = binding.edtNamaBarang.text.toString()
            val kode = binding.edtKodeBarng.text.toString().toInt()

            if(nama.isEmpty()){
                binding.edtNamaBarang.error ="Tidak Boleh Kosong"
            }
            setDataBarang(nama, kode)
        }
    }

    private fun setDataBarang(nama:String, kode:Int) {
        ServiceApi.api().addBarang(nama, kode).enqueue(object:Callback<SingleData<DataBarang>>{
            override fun onResponse(call: Call<SingleData<DataBarang>>, response: Response<SingleData<DataBarang>>) {
                if(response.isSuccessful){
                    startActivity(Intent(this@AddEditActivity, HomeActivity::class.java))
                }
            }

            override fun onFailure(call: Call<SingleData<DataBarang>>, t: Throwable) {
                Toast(this@AddEditActivity).apply {
                    duration = Toast.LENGTH_LONG
                    view = layoutInflater.inflate(R.layout.error, findViewById(R.id.ly_error))
                    show()
                }
            }

        })
    }
}