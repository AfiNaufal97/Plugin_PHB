package com.example.myretrofitlearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myretrofitlearn.adapter.AdapterHero
import com.example.myretrofitlearn.api.MultipleOption
import com.example.myretrofitlearn.api.Retrofits
import com.example.myretrofitlearn.databinding.ActivityMainBinding
import com.example.myretrofitlearn.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
        addData()
    }

    private fun addData() {
        binding.floatingBottom.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java)
                .putExtra("option", 1))
        }
    }

    private fun setView() {
        Retrofits.retrofit.getAllHero().enqueue(object:Callback<MultipleOption<Data>>{
            override fun onResponse(call: Call<MultipleOption<Data>>?, response: Response<MultipleOption<Data>>?) {
               if(response!!.isSuccessful){
                   if(response.body() != null){
                       response.body().data.also {
                           setRecylerView(it)
                       }
                   }
               }
            }

            override fun onFailure(call: Call<MultipleOption<Data>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "${t?.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setRecylerView(it: List<Data>) {
        val adapterHero = AdapterHero(it)
        binding.rvAll.apply {
            adapter = adapterHero
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapterHero.setClickHero(object:AdapterHero.SetOnClickHero{
                override fun clickList(data: Data) {
                    startActivity(Intent(this@MainActivity, DetailActivity::class.java)
                        .putExtra("id", data.id))
                }

            })
        }
    }
}