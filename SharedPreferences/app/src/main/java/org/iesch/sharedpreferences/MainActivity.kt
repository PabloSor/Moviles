package org.iesch.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.sharedpreferences.UserVipAplication.Companion.preferencias
import org.iesch.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initUI()

    }

    private fun IrADetalle() {
        startActivity(Intent(this, ResultActivity::class.java))
    }


    private fun initUI(){
        //Capturar el listener del boton
        binding.btnGuardar.setOnClickListener {
            comprobarValores()
        }
    }

    fun comprobarValores() {
        //Comprobaremos si tenemos el email y el nombre
        if(binding.etEmail.text.toString().isNotEmpty() && binding.etNombre.text.toString().isNotEmpty()){
            //Guardaremos la información del usuario
            preferencias.guardarNombre(binding.etNombre.text.toString())
            preferencias.guardarEmail(binding.etEmail.text.toString())
            preferencias.guardarVip(binding.cbVip.isChecked)

            IrADetalle()

        }else {
            // Haremos otra cosa por ejemplo un toast
            Toast.makeText(this, "Debes rellenar los dos campos editables", Toast.LENGTH_LONG).show()
        }
    }

}