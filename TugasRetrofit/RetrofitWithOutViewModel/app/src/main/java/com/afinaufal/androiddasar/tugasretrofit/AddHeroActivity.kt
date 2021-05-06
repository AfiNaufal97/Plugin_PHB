package com.afinaufal.androiddasar.tugasretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.afinaufal.androiddasar.tugasretrofit.api.RetrofitObject
import com.afinaufal.androiddasar.tugasretrofit.api.SingleResponse
import com.afinaufal.androiddasar.tugasretrofit.databinding.ActivityAddHeroBinding
import com.afinaufal.androiddasar.tugasretrofit.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddHeroActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentId = intent.getIntExtra("id", 0)
        val intentFirst = intent.getStringExtra("first_name")
        val intentLast = intent.getStringExtra("last_name")
        val intentEmail = intent.getStringExtra("email")
        val intentOp = intent.getIntExtra("options", 0)
        if(intentOp == 2){
            setEdit(intentId, intentFirst, intentLast, intentEmail)
            binding.btnEditHero.visibility = View.VISIBLE
            binding.titleAdd.text = "Edit Hero"
            if (intentId != null) {
                setBtnEdit(intentId, intentFirst, intentLast, intentEmail)
            }
        }else{
            binding.btnAddHero.visibility = View.VISIBLE
            setAddDataHero()
        }
    }

    private fun setBtnEdit(intentId: Int, intentFirst:String?, intentLast:String?, intentEmail:String?){
        binding.btnEditHero.setOnClickListener {
            setEditHero(intentId)
            finish()
        }
    }


    private fun setAddDataHero(){
        binding.btnAddHero.setOnClickListener {
            addHero()
            finish()
        }
    }

    private fun setEditHero(intentId: Int){
        val first_name = binding.addFirstName.text.toString()
        val last_name = binding.addLastName.text.toString()
        val email = binding.addEmail.text.toString()
        RetrofitObject.Api.editHero(intentId, first_name, last_name, email).enqueue(object :Callback<SingleResponse<Data>>{
            override fun onResponse(call: Call<SingleResponse<Data>>, response: Response<SingleResponse<Data>>) {
                if(response.isSuccessful){
                    val body = response
                    Toast.makeText(applicationContext, "sucess update data", Toast.LENGTH_SHORT).show()

                    println("sucess update data "+ body)
                }
            }

            override fun onFailure(call: Call<SingleResponse<Data>>, t: Throwable) {
               Toast.makeText(this@AddHeroActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun addHero(){
        val first_name = binding.addFirstName.text.toString()
        val last_name = binding.addLastName.text.toString()
        val email = binding.addEmail.text.toString()
        RetrofitObject.Api.addHero(first_name, last_name, email).enqueue(object :Callback<SingleResponse<Data>>{
            override fun onResponse(call: Call<SingleResponse<Data>>, response: Response<SingleResponse<Data>>) {
                if(response.isSuccessful){
                    val body = response.body()
                    Toast.makeText(this@AddHeroActivity, "Berhasil Di tambahkan", Toast.LENGTH_SHORT).show()
                    print("succes Add Data, $body")
                }
            }

            override fun onFailure(call: Call<SingleResponse<Data>>, t: Throwable) {
                Toast.makeText(this@AddHeroActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun setEdit(intentId: Int, intentFirst:String?, intentLast:String?, intentEmail:String?){
        binding.addFirstName.setText(intentFirst)
        binding.addLastName.setText(intentLast)
        binding.addEmail.setText(intentEmail)
    }
}