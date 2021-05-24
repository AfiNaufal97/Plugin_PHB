package com.example.myretrofitlearn

import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myretrofitlearn.api.Retrofits
import com.example.myretrofitlearn.api.SingleOption
import com.example.myretrofitlearn.databinding.ActivityDetailBinding
import com.example.myretrofitlearn.model.Data
import com.example.myretrofitlearn.model.DataSent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewDetail()
    }

    private fun clickEdit(id:Int, firstName:String, lastName:String, email:String){
        binding.btnUpdate.setOnClickListener {
            val data = DataSent(id, firstName, lastName, email)
            Intent(this, AddActivity::class.java).apply {
                putExtra("data", data)
                putExtra("option", 2)
                startActivity(this)
            }
        }
    }

    private fun setDelete(id:Int) {
        binding.btnDelete.setOnClickListener {
            Retrofits.retrofit.deleteHero(id).enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@DetailActivity, "Delete Succes", Toast.LENGTH_SHORT).show()
                        Intent(this@DetailActivity, MainActivity::class.java).apply {
                            this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(this)
                        }
                    }
                }

                override fun onFailure(call: Call<Void>?, t: Throwable?) {
                    Toast.makeText(this@DetailActivity, "${t?.message}", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    private fun setViewDetail() {
        val intent = intent.getIntExtra("id", 0)
        setValueDetail(intent)
        setDelete(intent)
    }

    private fun setValueDetail(intent: Int) {
        Retrofits.retrofit.detailHero(intent).enqueue(object :Callback<SingleOption<Data>>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<SingleOption<Data>>, response: Response<SingleOption<Data>>) {
                if(response.isSuccessful){
                    response.body().data.apply {
                        binding.tvNameDetail.text = this.first_name +" "+ this.last_name
                        clickEdit(this.id, this.first_name, this.last_name, this.email)
                    }
                }
            }

            override fun onFailure(call: Call<SingleOption<Data>>?, t: Throwable?) {
               Toast.makeText(this@DetailActivity, "${t?.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}