package org.iesch.sharedpreferences.Data.LocalData

import android.content.Context

// Nuestra clase Preferencias guardará y recuperará información
// Necesitaremos el contexto, y en principio aquí, no lo tenemos
class Preferencias (val context: Context){

    val SHARED_BD = "MiDB"
    val SHARED_USER_NAME = "username"
    val SHARED_USER_EMAIL = "email"
    val SHARED_VIP = "vip"

    val storage = context.getSharedPreferences(SHARED_BD, 0)

    fun guardarNombre(nombre: String){
        // Con la clave username, guárdame el valor que hay en el campo de nombre
        storage.edit().putString(SHARED_USER_NAME, nombre).apply()
    }

    fun guardarEmail(email: String){
        // Con la clave useremail, guárdame el valor que hay en el campo de email
        storage.edit().putString(SHARED_USER_EMAIL, email).apply()
    }

    fun guardarVip(vip: Boolean){
        // Le pasamos si vip esta seleccionado o no
        storage.edit().putBoolean(SHARED_VIP, vip).apply()
    }

    fun obtenerNombre() : String{
        return storage.getString(SHARED_USER_NAME, "no_name")!!
    }

    fun obtenerEmail() : String{
        return storage.getString(SHARED_USER_EMAIL, "no_email")!!
    }

    fun obtenerVip() : Boolean{
        return storage.getBoolean(SHARED_VIP, false)
    }

    fun borrarTodo(){
        storage.edit().clear().apply()
    }

}