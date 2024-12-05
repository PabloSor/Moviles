package org.iesch.puntosbaloncesto

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.puntosbaloncesto.databinding.ActivityMain2Binding
import org.iesch.puntosbaloncesto.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent:Bundle = intent.extras!!

        val local = intent.getString("LOCAL")
        val visitante = intent.getString("VISITANTE")

        if (local != null && visitante != null) {

            binding.tvPuntosFinal2.text = ("${local} - ${visitante}")

            if (local > visitante) {
                binding.tvResultado2.text = getString(R.string.local_ganador)
            } else {
                if (visitante > local) {
                    binding.tvResultado2.text = getString(R.string.visitante_ganador)
                } else {
                    binding.tvResultado2.text = getString(R.string.empate)
                }
            }
        }else{
            binding.tvPuntosFinal2.text = ("${local} - ${visitante}")
            binding.tvResultado2.text = getString(R.string.empate)
        }
    }
}