package com.afinaufal.androiddasar.sendvaluebetweenfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.afinaufal.androiddasar.sendvaluebetweenfragment.databinding.FragementHomeBinding

class FragmentHome : Fragment(), View.OnClickListener {

    private var _binding : FragementHomeBinding? = null
    val binding get() = _binding
    var nama:String = ""
    var squad:String = ""
    var angkatan:Int = 0
    var hobi:String =""
    lateinit var data:ContainerData


    companion object{
        const val EXTRA_DATA = "data"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragementHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.btnSendValue.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_send_value -> {
                if (cekData(binding!!.edtNama) && cekData(binding!!.edtSquad) && cekData(binding!!.edtAngkatan) && cekData(binding!!.edtHoby)) {
                    data = ContainerData(nama, squad, angkatan, hobi)
                    toDetail(data)
                    Toast.makeText(activity, "Data berhasil di input", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "Data error di input", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun toDetail(send:ContainerData ) {
        fragmentManager!!.beginTransaction().apply {
            val bundle = Bundle()
            bundle.putParcelable(EXTRA_DATA, send)
            val fragmentDetail = FragmentDetail()
            fragmentDetail.arguments = bundle
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fl_home, fragmentDetail)
                commit()
                activity?.actionBar?.title = "Data"
                binding!!.edtNama.text!!.clear()
                binding!!.edtAngkatan.text!!.clear()
                binding!!.edtSquad.text!!.clear()
                binding!!.edtHoby.text!!.clear()
            }
        }

        Log.d("hasil", send.nama)
    }

    private fun cekData(masukan:EditText):Boolean{
        var kembalian = false
        if(masukan.text.isNotEmpty()){
            when(masukan.id){
                R.id.edt_nama -> {
                    nama = masukan.text.toString()
                    kembalian = true
                }
                R.id.edt_squad -> {
                    squad = masukan.text.toString()
                    kembalian = true
                }
                R.id.edt_angkatan -> {
                    angkatan = masukan.text.toString().toInt()
                    kembalian = true
                }
                R.id.edt_hoby -> {
                    hobi = masukan.text.toString()
                    kembalian = true
                }
            }
        }else{
            masukan.error = "${masukan.hint} Tidak Boleh Kosong"
        }

        return kembalian
    }

}