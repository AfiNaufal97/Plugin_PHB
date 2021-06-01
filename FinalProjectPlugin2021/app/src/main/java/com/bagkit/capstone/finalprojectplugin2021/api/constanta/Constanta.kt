package com.bagkit.capstone.finalprojectplugin2021.api.constanta

import android.content.Context

class Constanta {
    companion object{
        const val BASE_URL = "https://apibarang.herokuapp.com/"
        fun setToken(context: Context, token:String){
            val setToken = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            setToken.edit().apply{
                putString("TOKEN", token)
                apply()
            }
        }

        fun setNameUser(context: Context, name:String){
            val setName = context.getSharedPreferences("NAME", Context.MODE_PRIVATE)
            setName.edit().apply{
                putString("NAME", name)
                apply()
            }
        }

        fun setUsername(context: Context, username:String){
            val setUsername = context.getSharedPreferences("USERNAME", Context.MODE_PRIVATE)
            setUsername.edit().apply{
                putString("USERNAME", username)
                apply()
            }
        }

        fun setEmailUser(context: Context, email:String){
            val setEmail = context.getSharedPreferences("EMAIL", Context.MODE_PRIVATE)
            setEmail.edit().apply{
                putString("EMAIL", email)
                apply()
            }
        }

        fun getToken(context: Context):String{
            val sharedPreferences = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            val token = sharedPreferences.getString("TOKEN", "Undefined")
            return token!!
        }

        fun getNameUser(context: Context):String{
            val sharedPreferences = context.getSharedPreferences("NAME", Context.MODE_PRIVATE)
            val nameUser = sharedPreferences.getString("NAME", "Undefined")
            return nameUser!!
        }

        fun getUsername(context: Context):String{
            val sharedPreferences = context.getSharedPreferences("USERNAME", Context.MODE_PRIVATE)
            val username = sharedPreferences.getString("USERNAME", "Undefined")
            return username!!
        }

        fun getEmailUser(context: Context):String{
            val sharedPreferences = context.getSharedPreferences("EMAIL", Context.MODE_PRIVATE)
            val emailUser = sharedPreferences.getString("EMAIL", "Undefined")
            return emailUser!!
        }

        fun deleteToken(context: Context){
            val eraseToken = context.getSharedPreferences("TOKEN",Context.MODE_PRIVATE)
            eraseToken.edit().clear().apply()
        }

        fun deleteName(context: Context){
            val eraseName = context.getSharedPreferences("NAME",Context.MODE_PRIVATE)
            eraseName.edit().clear().apply()
        }


        fun deleteUsername(context: Context){
            val eraseUsername = context.getSharedPreferences("NAME",Context.MODE_PRIVATE)
            eraseUsername.edit().clear().apply()
        }


        fun deleteEmail(context: Context){
            val eraseEmail = context.getSharedPreferences("NAME",Context.MODE_PRIVATE)
            eraseEmail.edit().clear().apply()
        }



    }
}