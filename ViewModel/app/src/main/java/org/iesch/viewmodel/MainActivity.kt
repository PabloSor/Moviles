package org.iesch.viewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import org.iesch.viewmodel.databinding.ActivityMainBinding
import org.iesch.viewmodel.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Creamos la variable para conectar la activity con nuestro ViewModel
    // Le especificamos el tipo y con el by nos hará toda la conexiónde ciclo de vida y demás.
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.viewContainer)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // A nuestro QuoteViewModel le vamos a observar la variable quoteModel con la función Observer
        quoteViewModel.quoteModel.observe(this, Observer {cita ->
            // Tod0 lo que tenemos aqui dentro estará enganchado a nuestro live data.
            //Cuando nuestro liveData tenga un cambio, cambiará la cita
            binding.tvCita.text = cita.cita
            binding.tvAutor.text = cita.autor
        })
        // Llamamos a la función de cambiar la Cita cuando toquemos la pantalla
        binding.viewContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }

    }
}