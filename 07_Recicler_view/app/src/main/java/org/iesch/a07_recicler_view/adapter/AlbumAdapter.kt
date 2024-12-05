package org.iesch.a07_recicler_view.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a07_recicler_view.R
import org.iesch.a07_recicler_view.model.Album


//le paso una lambda
class AlbumAdapter(private val listaDeAlbums:List<Album>, private val onClickListener: (Album) -> Unit) : RecyclerView.Adapter<AlbumViewHolder>() {
    //este listener esta en el adapter y tiene que llegar al viewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        //le pasamos el layout que vamos a modificar
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlbumViewHolder(layoutInflater.inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        //numero de elementos que va a tener el Recicler
        return listaDeAlbums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        // este metododo pasara por cada uno de los items  y llamara a la funcion render
        val item = listaDeAlbums[position]
        holder.render(item, onClickListener)
    }
}