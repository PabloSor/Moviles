package com.PabloSor.practica17.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.PabloSor.practica17.R
import com.PabloSor.practica17.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Funcion setupp para separar la lógica
        setup()

        //Comprobamos si hay una sesión
        session()
    }

    private fun setup() {
        //Pulsar en el boton REGISTER
        binding.btnRegister.setOnClickListener{
            irAResgistro()
        }
        // PULSAR EN EL BOTON LOGIN
        binding.btnLogin.setOnClickListener{
            // Comprobamos que se ha introducido usuario y contraseña
            if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()){

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
                    .addOnCompleteListener { respuesta ->

                        if (respuesta.isSuccessful) {

                            // Esto es porque se ha añadido el usuario a nuestro firebase
                            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                            irAHomeActivity(binding.etEmail.text.toString(), ProviderType.EMAIL_PASSWORD)

                        } else {
                            showError()
                        }
                    }

            }else{
                Toast.makeText(this, "Las contrseñas no coinciden", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun session(){
        val prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val provider = prefs.getString("provider", null)

        if (email != null && provider != null){
            binding.authLayout.visibility = View.INVISIBLE
            irAHomeActivity(email, ProviderType.valueOf(provider))
        }
    }

    override fun onStart() {
        super.onStart()
        binding.authLayout.visibility = View.VISIBLE
    }

    private fun irAResgistro() {
        val registerIntent = Intent(this, ResgisterActivity::class.java)
        startActivity(registerIntent)
    }

    private fun showError() {
        val builder = AlertDialog.Builder(this).setTitle("Error")
        builder.setMessage("Se ha producido un error al loguear al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun irAHomeActivity(email: String, provider: ProviderType){
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)

    }
}