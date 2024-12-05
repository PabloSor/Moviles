package com.PabloSor.practica17.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.PabloSor.practica17.R
import com.PabloSor.practica17.databinding.ActivityResgisterBinding
import com.google.firebase.auth.ActionCodeEmailInfo
import com.google.firebase.auth.FirebaseAuth

class ResgisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResgisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityResgisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setup()

    }

    private fun setup() {
        // PULSAR EN IR A LOGIN
        binding.btnIrALogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // PULSAR EN EL BOTON REGISTRAR
        binding.btnCrearCuenta.setOnClickListener{
            // Comprobamos que se ha introducido usuario y contraseña
            if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()){

                //Comprobamos que las contraseñas coincidan
                if (binding.etPassword.text.toString() == binding.etRepitPassword.text.toString()) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                        binding.etEmail.text.toString(),
                        binding.etPassword.text.toString()
                    )
                        .addOnCompleteListener { respuesta ->
                            if (respuesta.isSuccessful) {
                                // Esto es porque se ha añadido el usuario a nuestro firebase
                                Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                                irAHomeActivity(binding.etNombre.text.toString(), binding.etEmail.text.toString(), ProviderType.EMAIL_PASSWORD)
                            }else{
                                showError()
                            }
                        }
                }

            }else{
                Toast.makeText(this, "Las contrseñas no coinciden", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun irAHomeActivity(nombre: String, email: String, provider: ProviderType){
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("nombre", nombre)
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)

    }

    private fun showError() {
        val builder = AlertDialog.Builder(this).setTitle("Error al registrar")
        builder.setMessage("Se ha producido un error")
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}