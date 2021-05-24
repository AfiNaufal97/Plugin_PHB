package com.example.myretrofitlearn

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.myretrofitlearn.api.Retrofits
import com.example.myretrofitlearn.api.SingleOption
import com.example.myretrofitlearn.databinding.ActivityAddBinding
import com.example.myretrofitlearn.model.Data
import com.example.myretrofitlearn.model.DataSent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewAdd()
        addHero()
        setUpdate()
    }

    private fun setUpdate() {
        val intentOption = intent.getIntExtra("option", 0)
        setButtonView(intentOption)
        val intentId = intent.getParcelableExtra<DataSent>("data")
        if(intentId != null){
            setUpdateData(intentId)
            binding.edtNamaDepan.setText(intentId.firtsName)
            binding.edtNamaBelakang.setText(intentId.lastName)
            binding.edtEmail.setText(intentId.email)
        }
    }

    private fun setUpdateData(data:DataSent) {
        binding.btnEditHero.setOnClickListener {
            val firstName = binding.edtNamaDepan.text.toString()
            val lastName = binding.edtNamaBelakang.text.toString()
            val email= binding.edtEmail.text.toString()
            Retrofits.retrofit.editHero(data.id, firstName, lastName, email).enqueue(object :Callback<SingleOption<Data>>{
                override fun onResponse(call: Call<SingleOption<Data>>, response: Response<SingleOption<Data>>) {
                    if(response.isSuccessful){
                        val body = response
                                Toast.makeText(this@AddActivity, "${body.message()}", Toast.LENGTH_SHORT).show()
                                Intent(this@AddActivity, MainActivity::class.java).apply {
                                    this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    startActivity(this)
                                }
                            }
                }

                override fun onFailure(call: Call<SingleOption<Data>>?, t: Throwable?) {
                   Toast.makeText(this@AddActivity, "${t?.message}", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    private fun addHero() {
        binding.btnAdd.setOnClickListener {
            val firstName = binding.edtNamaDepan.text.toString()
            val lastName = binding.edtNamaBelakang.text.toString()
            val email = binding.edtEmail.text.toString()
            Retrofits.retrofit.addHero(firstName, lastName, email).enqueue(object :Callback<SingleOption<Data>>{
                override fun onResponse(call: Call<SingleOption<Data>>, response: Response<SingleOption<Data>>) {
                    if(response.isSuccessful){
                        response.body().data.apply {
                            Toast.makeText(this@AddActivity, "${this.first_name} berhasil di tambahkan", Toast.LENGTH_SHORT).show()
                            Intent(this@AddActivity, MainActivity::class.java).apply {
                                this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(this)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<SingleOption<Data>>?, t: Throwable?) {
                    Toast.makeText(this@AddActivity, "${t?.message}", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }



    private fun setViewAdd() {
        val intent = intent.getIntExtra("option", 0)
        setButtonView(intent)
    }

    @SuppressLint("SetTextI18n")
    private fun setButtonView(intent: Int) {
        when(intent){
            1 -> {
                binding.btnEditHero.visibility = View.GONE
                binding.btnAdd.visibility = View.VISIBLE
                binding.tvTitleAdd.text = "Add Hero"
            }
            2 -> {
                binding.btnAdd.visibility = View.GONE
                binding.btnEditHero.visibility = View.VISIBLE
                binding.tvTitleAdd.text = "Update Hero"
            }
        }
    }
}