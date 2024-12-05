package org.iesch.edadcanina.ElSorpas

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.edadcanina.ElSorpas.R.id.tvRespuesta
import org.iesch.edadcanina.ElSorpas.databinding.ActivityMainBinding

// Añadimos Data Binding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Control sobre las Vistas que necesitamos
        //val resulText = findViewById<TextView>(R.id.tvRespuesta)
        //val calculateButton = findViewById<Button>(R.id.btnCalcular)
        //val ageEdit = findViewById<EditText>(R.id.etEdad)



        //Log en android
        //Log.i("DAM2", "Esto es un log de tipo INFO")
        //Log.v("DAM2", "Esto es un bug de tipo VERBOSE")
        //Log.d("DAM2", "Esto es un log de tipo DEBUG")
        //Log.w("DAM2", "Esto es un log de tipo WARNING")
        //Log.e("DAM2", "Esto es un log de tipo ERROR")

        //Los botones tienen onClickListener cuando los pulsas
        binding.btnCalcular.setOnClickListener{
            //Log.i("EdadCanina", "Has pulsado click en el boton calcular")
            val ageString = binding.etEdad.text.toString()

            if (ageString.isEmpty()){
                //No hacemos nada
                //Log.i("Edad canina", "No has introducido nungún número")
                Toast.makeText(this, "Debes introducir un valor numéric", Toast.LENGTH_LONG).show()
            }else {
                val ageInt = ageString.toInt()
                val dogAge = ageInt * 7
                binding.tvRespuesta.text = getString(R.string.resultado, dogAge)
            }
        }
    }
}