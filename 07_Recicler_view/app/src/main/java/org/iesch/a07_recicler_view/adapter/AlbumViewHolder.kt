package org.iesch.a07_recicler_view.adapter

import android.graphics.ColorSpace.Model
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.iesch.a07_recicler_view.R
import org.iesch.a07_recicler_view.databinding.ItemAlbumBinding
import org.iesch.a07_recicler_view.model.Album

class AlbumViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemAlbumBinding.bind(view)

    //creamos una funcion que se ejecuta por cada album

    fun render(albumModel: Album, onClickListener:(Album) -> Unit){
        binding.tvTitulo.text = albumModel.titulo
        binding.tvAnio.text = albumModel.anio.toString()
        binding.tvAutor.text = albumModel.autor

        Glide.with(binding.imgAlbum.context).load(albumModel.portada).into(binding.imgAlbum)

        //ahora cada vez que pulse en un item vamos a llamar a la funcion lambda
        itemView.setOnClickListener{
            onClickListener(albumModel)
        }

//        //controlamos las fotos
//        binding.imgAlbum.setOnClickListener{
//            Toast.makeText(binding.imgAlbum.context, albumModel.autor, Toast.LENGTH_SHORT).show()
//        }
//
//        //si queremos controlar toda la celda (lo mas común)
//        itemView.setOnClickListener{
//            Toast.makeText(binding.imgAlbum.context, albumModel.titulo, Toast.LENGTH_SHORT).show()
//        }
    }
}