package org.iesch.a07_recicler_view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a07_recicler_view.adapter.AlbumAdapter
import org.iesch.a07_recicler_view.databinding.ActivityMainBinding
import org.iesch.a07_recicler_view.model.Album
import org.iesch.a07_recicler_view.provider.AlbumProvider


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

        initRecyclerView()

    }

    private fun initRecyclerView() {
        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,layout.orientation)

        binding.reciclerAlbun.layoutManager = layout

        // Ahora el Activity me esta diciendo que necesita un parámetro para el onClickListener (La función lambda)
        // It es la parte más confusa, cuando llame a esa funcion le voy a pasar el It, que va a ser el contenido del album
        binding.reciclerAlbun.adapter = AlbumAdapter(AlbumProvider.listaDeAlbums) { album ->
            onItemSelected(
                album
            )
        }
        binding.reciclerAlbun.addItemDecoration(decoration)
    }

    // Esta funcion va a recibir un Album
    fun onItemSelected(album: Album){
        // Creamos un Toast para comprobar que funciona
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
    }
}