package com.afinaufal.androiddasar.tugasretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.afinaufal.androiddasar.tugasretrofit.adapter.AdapterHero
import com.afinaufal.androiddasar.tugasretrofit.api.MultipleResponse
import com.afinaufal.androiddasar.tugasretrofit.api.RetrofitObject
import com.afinaufal.androiddasar.tugasretrofit.api.SingleResponse
import com.afinaufal.androiddasar.tugasretrofit.databinding.ActivityMainBinding
import com.afinaufal.androiddasar.tugasretrofit.model.Data
import com.afinaufal.androiddasar.tugasretrofit.model.Heroku
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getApi()
    }

    private fun getApi() {
        RetrofitObject.Api.getAllHero().enqueue(object :Callback<MultipleResponse<Data>>{
            override fun onResponse(call: Call<MultipleResponse<Data>>, response: Response<MultipleResponse<Data>>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        setRecyclerview(body.data)
                    }
                }
            }

            override fun onFailure(call: Call<MultipleResponse<Data>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setRecyclerview(data: List<Data>) {
        val adapterHero = AdapterHero(data)
        binding.rvAllHero.apply {
            adapter = adapterHero
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapterHero.clickItemHero(object :AdapterHero.OnItemHeroClickListener{
                override fun clickItem(data: Data) {
                   Intent(this@MainActivity, DetailActivity::class.java).apply{
                       putExtra(DetailActivity.EXTRA, data.id)
                       startActivity(this)
                   }
                }

            })
        }
    }

}