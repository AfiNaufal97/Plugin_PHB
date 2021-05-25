package com.example.retrofitloginregister

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitloginregister.api.APIWithRetrofit
import com.example.retrofitloginregister.databinding.FormRegisterActivityBinding
import com.example.retrofitloginregister.model.SingleResponse
import com.example.retrofitloginregister.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormRegister:AppCompatActivity() {

    private lateinit var binding:FormRegisterActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FormRegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickButtonRegister()
    }

    private fun clickButtonRegister() {
        binding.btnRegister.setOnClickListener {
            Register()
            startActivity(Intent(this, FormLogin::class.java))
            finish()
        }
    }

    private fun Register() {
        val username = binding.edtUsername.text.toString()
        val name = binding.edtName.text.toString()
        val email = binding.edtEmailReg.text.toString()
        val password = binding.edtPassword.text.toString()

        APIWithRetrofit.api().SignUpUser(name, username, email, password).enqueue(object:Callback<SingleResponse<Users>>{
            override fun onResponse(call: Call<SingleResponse<Users>>, response: Response<SingleResponse<Users>>) {
               if(response.isSuccessful){
                   val body = response.body()
                   if(body != null){
                       Toast.makeText(applicationContext, body.msg, Toast.LENGTH_SHORT).show()
                   }
               }else{
                   val errorBody = response.errorBody().toString()
                   val code = response.code()
                   Log.e("xxxxx", errorBody)
                   Toast.makeText(applicationContext, code.toString(), Toast.LENGTH_SHORT).show()
               }
            }

            override fun onFailure(call: Call<SingleResponse<Users>>, t: Throwable) {
                print(t.message)
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

}