package com.bagkit.capstone.finalprojectplugin2021.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bagkit.capstone.finalprojectplugin2021.api.ServiceApi
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.DataApi
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.SingleData
import com.bagkit.capstone.finalprojectplugin2021.databinding.FragmentRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment: Fragment(){
    private var _binding:FragmentRegisterBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.btnRegister.setOnClickListener {
            setRegister()
        }
    }

    private fun setRegister() {
        val name = binding!!.edtName.text.toString()
        val username = binding!!.edtUsername.text.toString()
        val email = binding!!.edtEmailReg.text.toString()
        val password = binding!!.edtPassword.text.toString()

        if(name.isEmpty()){
            binding!!.edtName.error ="Tidak boleh Kosong"
        }
        if(username.isEmpty()){
            binding!!.edtUsername.error ="Tidak boleh Kosong"
        }
        if(email.isEmpty()){
            binding!!.edtEmailReg.error ="Tidak boleh Kosong"
        }
        if(password.isEmpty()){
            binding!!.edtPassword.error ="Tidak boleh Kosong"
        }

        formRegister(name, username, email, password)

    }

    private fun formRegister(name: String, username: String, email: String, password: String) {
        ServiceApi.api().registerUser(name, username, email, password).enqueue(object:Callback<SingleData<DataApi>>{
            override fun onResponse(call: Call<SingleData<DataApi>>, response: Response<SingleData<DataApi>>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        Toast.makeText(activity, body.msg, Toast.LENGTH_SHORT).show()
                    }
                }else{
                    val errorBody = response.errorBody().toString()
                    val code = response.code()
                    Log.e("xxxxx", errorBody)
                    Toast.makeText(activity, code.toString(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SingleData<DataApi>>, t: Throwable) {
                print(t.message)
                Toast.makeText(activity,t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }


}