package com.PabloSor.practica17.view

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.PabloSor.practica17.R
import com.PabloSor.practica17.databinding.ActivityHomeBinding
import com.PabloSor.practica17.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    EMAIL_PASSWORD,
    GOOGLE
}

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recuperamos los datos del Bundle
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")

        // Guardado de datos
        val prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE)
        prefs.edit().putString("email", email).putString("provider", provider).apply()

        setup(email ?: "", provider ?: "")

    }
    private fun setup(email: String, provider: String){
        title = "Home"
        binding.etEmail.text.toString()
        binding.tvProvider.text.toString()

        //Bonton cerrar sesion
        binding.btnCerrar.setOnClickListener{

            // borrar datos de inicio de sesión al hacer logout
            val prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE)
            prefs.edit().clear().apply()

            FirebaseAuth.getInstance().signOut()
            finish()
        }
    }
}