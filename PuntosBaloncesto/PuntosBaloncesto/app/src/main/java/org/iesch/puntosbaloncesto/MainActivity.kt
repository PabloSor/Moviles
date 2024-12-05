package org.iesch.puntosbaloncesto

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.puntosbaloncesto.databinding.ActivityMain2Binding
import org.iesch.puntosbaloncesto.databinding.ActivityMainBinding

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

        var localPoints = 0
        var visitPoints = 0


        //Tiros libres
        binding.btnTiroLibre1.setOnClickListener{
            localPoints++
            binding.tvMarcador1.text = localPoints.toString()
        }

        binding.btnTiroLibre2.setOnClickListener{
            visitPoints++
            binding.tvMarcador2.text = visitPoints.toString()
        }


        //Canastas
        binding.btnPunto1.setOnClickListener{
            localPoints += 2
            binding.tvMarcador1.text = localPoints.toString()
        }

        binding.btnPunto2.setOnClickListener{
            visitPoints += 2
            binding.tvMarcador2.text = visitPoints.toString()
        }


        //Triples
        binding.btnTriple1.setOnClickListener{
            localPoints += 3
            binding.tvMarcador1.text = localPoints.toString()
        }

        binding.btnTriple2.setOnClickListener{
            visitPoints += 3
            binding.tvMarcador2.text = visitPoints.toString()
        }


        //Restar puntos
        binding.btnRestar1.setOnClickListener{

            if (localPoints > 0) {
                localPoints -= 1
                binding.tvMarcador1.text = localPoints.toString()
            }
        }

        binding.btnRestar2.setOnClickListener{

            if (visitPoints > 0) {
                visitPoints -= 1
                binding.tvMarcador2.text = visitPoints.toString()
            }
        }


        //Reiniciar marcadores
        binding.btnReiniciar.setOnClickListener {
            localPoints = 0
            visitPoints = 0

            binding.tvMarcador1.text = localPoints.toString()
            binding.tvMarcador2.text = visitPoints.toString()
        }


        //Fin partido
        binding.btnFinPartido.setOnClickListener{
            val localMarcador = localPoints
            val visitMarcador = visitPoints

            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("LOCAL", localMarcador.toString())
            intent.putExtra("VISITANTE", visitMarcador.toString())

            startActivity(intent)
        }

    }
}