package org.iesch.practica_05_quizz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import org.iesch.practica_05_quizz.databinding.ActivityMain2Binding
import org.iesch.practica_05_quizz.databinding.ActivityMainBinding

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

        val intent: Bundle? = intent.extras
        val pregunta = intent?.getInt("PREGUNTA") ?: 1

        if (pregunta == 1) {
            binding.tvPregunta.text = getString(R.string.pregunta_1)

            binding.tvPregunta1.text = getString(R.string.respuesta_a_1)
            binding.tvPregunta2.text = getString(R.string.respuesta_b_1)
        }else if (pregunta == 2){
            binding.tvPregunta.text = getString(R.string.pregunta_2)

            binding.tvPregunta1.text = getString(R.string.respuesta_a_2)
            binding.tvPregunta2.text = getString(R.string.respuesta_b_2)
        }else if (pregunta == 3){
            binding.tvPregunta.text = getString(R.string.pregunta_3)

            binding.tvPregunta1.text = getString(R.string.respuesta_a_3)
            binding.tvPregunta2.text = getString(R.string.respuesta_b_3)
        }else if (pregunta == 4){
            binding.tvPregunta.text = getString(R.string.pregunta_4)

            binding.tvPregunta1.text = getString(R.string.respuesta_a_4)
            binding.tvPregunta2.text = getString(R.string.respuesta_b_4)
        }else if (pregunta == 5){
            binding.tvPregunta.text = getString(R.string.pregunta_5)

            binding.tvPregunta1.text = getString(R.string.respuesta_a_5)
            binding.tvPregunta2.text = getString(R.string.respuesta_b_5)
        }else if (pregunta == 6){
            binding.tvPregunta.text = getString(R.string.finTest)
            binding.btnEnviar.visibility = View.GONE
        }else{
            Toast.makeText(this, "Se ha producido un error", Toast.LENGTH_LONG).show()
        }

        binding.btnEnviar.setOnClickListener{
            if (binding.Rbtn1.isChecked){
                val respuesta = "a"
                val intent = Intent(this, MainActivity2::class.java)

                intent.putExtra("RESPUESTA", respuesta)
                intent.putExtra("PREGUNTA", pregunta)
                startActivity(intent)

            }else if (binding.Rbtn2.isChecked){
                val respuesta = "b"
                val intent = Intent(this, MainActivity2::class.java)

                intent.putExtra("RESPUESTA", respuesta)
                intent.putExtra("PREGUNTA", pregunta)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Debes elegir una de las opciones", Toast.LENGTH_LONG).show()
            }
        }

    }
}