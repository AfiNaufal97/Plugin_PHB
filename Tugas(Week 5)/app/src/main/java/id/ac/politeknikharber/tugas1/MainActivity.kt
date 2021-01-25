package id.ac.politeknikharber.tugas1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Profile"

        val mail:ImageView = findViewById(R.id.iv_email)
        val telpon:ImageView = findViewById(R.id.iv_telpon)
        val ig:ImageView = findViewById(R.id.iv_intagram)

        mail.setOnClickListener {
           val cekEmail =  Intent(Intent.ACTION_SEND)
           cekEmail.data = Uri.parse("mailto:")
            cekEmail.type = "text/plan"
            cekEmail.putExtra(Intent.EXTRA_EMAIL, "naufal.setiawan92@gmail.com")
            cekEmail.putExtra(Intent.EXTRA_SUBJECT,"PEsan Untuk Kamu")
            cekEmail.putExtra(Intent.EXTRA_TEXT, "Hallo Saya Ingin menyapamu :)")
            startActivity(cekEmail)
        }

        val number = "tel:083836766137"
        telpon.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(number)))
        }

        val alamatIg = Uri.parse("https://www.instagram.com/afi_naufal/")
        ig.setOnClickListener {
            val instagram  = Intent(Intent.ACTION_VIEW, alamatIg)
            instagram.setPackage("com.instagram.android")

           try {
               startActivity(instagram)
           }catch (e : Exception){
               startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/afi_naufal/")))
           }

        }

    }
}