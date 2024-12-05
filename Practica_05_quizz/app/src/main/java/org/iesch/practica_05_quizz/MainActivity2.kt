package org.iesch.practica_05_quizz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.practica_05_quizz.databinding.ActivityMain2Binding
import org.iesch.practica_05_quizz.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent:Bundle = intent.extras!!

        val respuesta = intent.getString("RESPUESTA")
        var pregunta = intent.getInt("PREGUNTA")

        if (respuesta != null) {
            if (pregunta == 1) {
                if (respuesta == "a") {
                    binding.tvRespuesta.text = getString(R.string.correcto)
                } else {
                    binding.tvRespuesta.text = getString(R.string.incorrecto)
                }

                binding.tvExplicacion.text = getString(R.string.explicacion_1)

            } else if (pregunta == 2) {
                if (respuesta == "a") {
                    binding.tvRespuesta.text = getString(R.string.correcto)
                } else {
                    binding.tvRespuesta.text = getString(R.string.incorrecto)
                }

                binding.tvExplicacion.text = getString(R.string.explicacion_2)

            } else if (pregunta == 3) {
                if (respuesta == "a") {
                    binding.tvRespuesta.text = getString(R.string.correcto)
                } else {
                    binding.tvRespuesta.text = getString(R.string.incorrecto)
                }

                binding.tvExplicacion.text = getString(R.string.explicacion_3)

            } else if (pregunta == 4) {
                if (respuesta == "a") {
                    binding.tvRespuesta.text = getString(R.string.correcto)
                } else {
                    binding.tvRespuesta.text = getString(R.string.incorrecto)
                }

                binding.tvExplicacion.text = getString(R.string.explicacion_4)

            } else if (pregunta == 5) {
                if (respuesta == "a") {
                    binding.tvRespuesta.text = getString(R.string.correcto)
                } else {
                    binding.tvRespuesta.text = getString(R.string.incorrecto)
                }

                binding.tvExplicacion.text = getString(R.string.explicacion_5)
            } else {
                Toast.makeText(this, "Se ha producido un error", Toast.LENGTH_LONG).show()
            }

            binding.btnNext.setOnClickListener {
                pregunta ++
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("PREGUNTA", pregunta)
                startActivity(intent)
            }
        }

    }
}