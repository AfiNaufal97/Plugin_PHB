package com.example.tugasweek5_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasweek5_.databinding.ActivityLoginBinding
import com.example.tugasweek5_.model.User
import com.example.tugasweek5_.response.SingleResponse
import com.example.tugasweek5_.webservise.ApiServise
import com.example.tugasweek5_.webservise.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickSignIn()
        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

        override fun onResume() {
        super.onResume()
        //isLogin()
    }

    private fun isLogin(){
        val token = Constant.getToken(this)
        if(!token.equals("UNDEFINED")){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun clickSignIn() {
        binding.btnSignIn.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            ApiServise.ApiEndpoint().signin( email , password).enqueue(object : Callback<SingleResponse<User>>{
                override fun onFailure(call: Call<SingleResponse<User>>, t: Throwable) {
                    println(t.message)
                    Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<SingleResponse<User>>, response: Response<SingleResponse<User>>) {
                    if(response.isSuccessful){
                        val body = response.body()
                        if(body != null){
                            Constant.setToken(this@LoginActivity,body.data.token)
                            Toast.makeText(applicationContext,"hii ${body.data.username}",Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(applicationContext,"Login Failed",Toast.LENGTH_SHORT).show()
                    }
                }

            })
        }
    }
}