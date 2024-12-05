package org.iesch.sharedpreferences

import android.app.Application
import org.iesch.sharedpreferences.Data.LocalData.Preferencias

// Esta clase quiero que se ejecute antes de arrancar la aplicación, para ello extiendo de App
// Podemos meter lógica aquí que queramos usar en toda la aplicación
class UserVipAplication : Application() {

    companion object {
        lateinit var preferencias: Preferencias
    }

    override fun onCreate() {
        super.onCreate()
        // Cuando arranque la app haz lo que pone aquí
        preferencias = Preferencias(applicationContext)
    }

}