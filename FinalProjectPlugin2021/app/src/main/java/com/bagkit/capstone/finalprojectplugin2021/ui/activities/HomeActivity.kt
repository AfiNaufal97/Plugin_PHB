package com.bagkit.capstone.finalprojectplugin2021.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.finalprojectplugin2021.R
import com.bagkit.capstone.finalprojectplugin2021.adapter.AdapterBarang
import com.bagkit.capstone.finalprojectplugin2021.api.ServiceApi
import com.bagkit.capstone.finalprojectplugin2021.api.constanta.Constanta
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.DataBarang
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.MultipleData
import com.bagkit.capstone.finalprojectplugin2021.databinding.HomeActivityBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity:AppCompatActivity(){

    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setProfile()
        setApiBarang()
        addData()
        binding.imageViewProfile.setOnClickListener {
            startActivity(Intent(this, MyProfileActivity::class.java))
        }
    }

    private fun addData() {
        binding.floatingAdd.setOnClickListener{
            startActivity(Intent(this, AddEditActivity::class.java)
                .putExtra("OPTIONS", 1))
        }
    }

    private fun setApiBarang() {
        ServiceApi.api().getAllBarang().enqueue(object: Callback<MultipleData<DataBarang>> {
            override fun onResponse(call: Call<MultipleData<DataBarang>>, response: Response<MultipleData<DataBarang>>) {
                if(response.isSuccessful){
                    val body = response.body()!!.data
                    if(body != null){
                        val data = body
                        setView(data)
                        Toast.makeText(this@HomeActivity, "${data.get(1)}", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast(this@HomeActivity).apply {
                            duration = Toast.LENGTH_LONG
                            view = layoutInflater.inflate(R.layout.error, findViewById(R.id.ly_error))
                            show()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MultipleData<DataBarang>>, t: Throwable) {
                Toast(this@HomeActivity).apply {
                    duration = Toast.LENGTH_LONG
                    view = layoutInflater.inflate(R.layout.error, findViewById(R.id.ly_error))
                    show()
                }
            }

        })
    }

    private fun setView(data:List<DataBarang>) {
        binding.rvListProduct.apply {
            val adapterBarang = AdapterBarang(data)
            setHasFixedSize(true)
            adapter = adapterBarang
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapterBarang.clickListBarang(object:AdapterBarang.OnClickBarang{
                override fun clickBarang(data: DataBarang) {
                    Toast.makeText(this@HomeActivity, "${data.id}", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@HomeActivity, DetailBarangActivity::class.java)
                        .putExtra("id", data.id)) }

            })
        }
    }


    private fun setProfile() {
        val nameUser = binding.tvNameUser
        nameUser.text = Constanta.getUsername(this)
    }

}