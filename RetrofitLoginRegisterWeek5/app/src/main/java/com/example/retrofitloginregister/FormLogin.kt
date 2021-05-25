package com.example.retrofitloginregister

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitloginregister.api.APIWithRetrofit
import com.example.retrofitloginregister.api.Constanta
import com.example.retrofitloginregister.databinding.FormLoginActivityBinding
import com.example.retrofitloginregister.model.SingleResponse
import com.example.retrofitloginregister.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormLogin:AppCompatActivity(){

    private lateinit var binding: FormLoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FormLoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toFormRegister()
        clickLogin()
    }

    private fun clickLogin() {
        binding.btnLogin.setOnClickListener {
            loginProcess()
        }
    }

    private fun loginProcess() {
        val username = binding.edtUseranmeLogin.text.toString()
        val password = binding.edtPassword.text.toString()

        APIWithRetrofit.api().SignUser(username, password).enqueue(object:Callback<SingleResponse<Users>>{
            override fun onResponse(call: Call<SingleResponse<Users>>, response: Response<SingleResponse<Users>>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        Constanta.setToken(this@FormLogin, body.data.token)
                        Toast.makeText(applicationContext, "Hallo ${body.data.name}", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(applicationContext, "Gagal Masuk", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SingleResponse<Users>>, t: Throwable) {
               print(t.message)
                Toast.makeText(applicationContext, "Gagal Masuk", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun toFormRegister() {
        binding.tvToRegister.setOnClickListener {
            startActivity(Intent(this, FormRegister::class.java))
        }
    }
}