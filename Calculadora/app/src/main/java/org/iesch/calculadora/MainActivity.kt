package org.iesch.calculadora

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import org.iesch.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.sumar.setOnClickListener {
            realizarOperacion("sumar")
        }

        binding.restar.setOnClickListener {
            realizarOperacion("restar")
        }

        binding.multi.setOnClickListener {
            realizarOperacion("multi")
        }

        binding.div.setOnClickListener {
            realizarOperacion("div")
        }

    }
    private fun realizarOperacion(operacion: String) {
        val numero1Str = binding.num1.text.toString()
        val numero2Str = binding.num2.text.toString()

        if (numero1Str.isNotEmpty() && numero2Str.isNotEmpty()) {
            val num1 = numero1Str.toDoubleOrNull()
            val num2 = numero2Str.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                var resultadoOperacion = 0.0

                when (operacion) {
                    "sumar" -> resultadoOperacion = num1 + num2
                    "restar" -> resultadoOperacion = num1 - num2
                    "multi" -> resultadoOperacion = num1 * num2
                    "div" -> resultadoOperacion = num1 / num2
                }

                binding.result.text = "$resultadoOperacion"
            } else {
                binding.result.text = "Error en la conversión a número"
            }
        } else {
            binding.result.text = "Introduce ambos números"
        }
    }
}
