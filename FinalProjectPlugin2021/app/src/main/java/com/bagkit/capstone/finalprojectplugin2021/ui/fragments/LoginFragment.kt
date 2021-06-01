package com.bagkit.capstone.finalprojectplugin2021.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bagkit.capstone.finalprojectplugin2021.R
import com.bagkit.capstone.finalprojectplugin2021.api.ServiceApi
import com.bagkit.capstone.finalprojectplugin2021.api.constanta.Constanta
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.DataApi
import com.bagkit.capstone.finalprojectplugin2021.api.modelapi.SingleData
import com.bagkit.capstone.finalprojectplugin2021.databinding.FragmentLoginBinding
import com.bagkit.capstone.finalprojectplugin2021.ui.activities.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private var _binding:FragmentLoginBinding? = null
    private val binding get() = _binding

    override fun onResume() {
        super.onResume()
        if(Constanta.getToken(requireContext()) != "Undefined"){
            startActivity(Intent(activity, HomeActivity::class.java).also {
                requireActivity().finish()
            })
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       _binding = FragmentLoginBinding.inflate(layoutInflater,container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.btnLogin.setOnClickListener{
            setLogin()
        }
    }

    private fun setLogin() {
        val name = binding!!.edtUseranmeLogin.text.toString()
        val password = binding!!.edtPassword.text.toString()

        if(name.isEmpty()){
            binding!!.edtUseranmeLogin.error ="Tidak boleh Kososng"
        }

        if(password.isEmpty()){
            binding!!.edtPassword.error ="Tidak boleh Kososng"
        }

        formLogin(name, password)
    }

    private fun formLogin(name:String, password:String){
        ServiceApi.api().loginUser(name, password).enqueue(object:Callback<SingleData<DataApi>>{
            override fun onResponse(call: Call<SingleData<DataApi>>, response: Response<SingleData<DataApi>>) {
                if(response.isSuccessful){
                    val body = response.body()!!.data
                    if(body != null){
                        Constanta.setToken(activity!!, body.token)
                        Constanta.setNameUser(activity!!, body.name)
                        Constanta.setUsername(activity!!, body.username)
                        Constanta.setEmailUser(activity!!, body.email)
                        Toast.makeText(activity, "Hallo ${body.name}", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(activity, HomeActivity::class.java))
                    }
                }else{
                    Toast(activity).apply {
                        duration = Toast.LENGTH_LONG
                        view = layoutInflater.inflate(R.layout.error, activity!!.findViewById(R.id.ly_error))
                        show()
                    }
                }
            }

            override fun onFailure(call: Call<SingleData<DataApi>>, t: Throwable) {
                Toast(activity).apply {
                    duration = Toast.LENGTH_LONG
                    view = layoutInflater.inflate(R.layout.error, activity!!.findViewById(R.id.ly_error))
                    show()
                }
            }

        })
    }

}