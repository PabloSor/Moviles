package org.iesch.a05_listview_versiones_android

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.a05_listview_versiones_android.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
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

        val arrayAdapter: ArrayAdapter<*>
        val versiones = mutableListOf("Pie", "Oreo", "Nougat", "Marshmallow", "Lollipop", "Kitkat", "JellyBean", "Ice Cream", "Tiramisu", "...")
        val lvDatos = binding.listaversiones
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, versiones)
        lvDatos.adapter = arrayAdapter
        lvDatos.setOnItemClickListener { adapterView, view, position, id -> Toast.makeText(this, adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show() }
    }
}