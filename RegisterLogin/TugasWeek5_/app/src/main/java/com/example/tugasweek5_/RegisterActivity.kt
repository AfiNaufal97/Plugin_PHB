package com.example.tugasweek5_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tugasweek5_.databinding.ActivityRegisterBinding
import com.example.tugasweek5_.model.User
import com.example.tugasweek5_.response.SingleResponse
import com.example.tugasweek5_.webservise.ApiServise
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickSignup()
    }
    private fun clickSignup() {
        binding.btnSignUp.setOnClickListener {
            createAccount()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun createAccount() {
        val username = binding.edtUsername.text.toString()
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.toString()

        ApiServise.ApiEndpoint().resgister(username, email, password).enqueue(object:
            Callback<SingleResponse<User>> {
            override fun onResponse(call: Call<SingleResponse<User>>, response: Response<SingleResponse<User>>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        Toast.makeText(this@RegisterActivity, body.msg, Toast.LENGTH_SHORT).show()
                    }
                }else{
                    val errorBody = response.errorBody().toString()
                    val code = response.code()
                    Log.e("xxxxx", errorBody)
                    Toast.makeText(this@RegisterActivity, code.toString(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SingleResponse<User>>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}