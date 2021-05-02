package com.afinaufal.androiddasar.tugasretrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.afinaufal.androiddasar.tugasretrofit.api.RetrofitObject
import com.afinaufal.androiddasar.tugasretrofit.api.SingleResponse
import com.afinaufal.androiddasar.tugasretrofit.databinding.ActivityDetailBinding
import com.afinaufal.androiddasar.tugasretrofit.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding
    companion object{
        const val EXTRA = "extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentData = intent.getIntExtra(EXTRA, 0)

        getDetailApi(intentData)
        btnDelete(intentData)

    }

    private fun btnDelete(intentData: Int) {
        binding.btnDelete.setOnClickListener {
            deleteHero(intentData)
            finish()
        }
    }

    private fun deleteHero(intentData: Int) {
       RetrofitObject.Api.deleteHero(intentData).enqueue(object :Callback<Void>{
           override fun onResponse(call: Call<Void>, response: Response<Void>) {
              if(response.isSuccessful){
                 Toast.makeText(this@DetailActivity, "${response.code().toString()}", Toast.LENGTH_LONG).show()
              }
           }

           override fun onFailure(call: Call<Void>, t: Throwable) {
               Toast.makeText(this@DetailActivity, "${t.message}", Toast.LENGTH_SHORT).show()
           }

       })
    }

    private fun getDetailApi(intentData: Int) {
        RetrofitObject.Api.getDeailHero(intentData).enqueue(object :Callback<SingleResponse<Data>>{
            override fun onResponse(call: Call<SingleResponse<Data>>, response: Response<SingleResponse<Data>>) {
                if(response.isSuccessful){
                    response.body().let {
                        setViewDetail(it!!.data)
                    }
                }
            }

            override fun onFailure(call: Call<SingleResponse<Data>>, t: Throwable) {
               Toast.makeText(this@DetailActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun setViewDetail(data: Data) {
        binding.tvNameDetailHero.text = data.first_name +" "+ data.last_name
        binding.tvEmail.text = data.email
    }


}