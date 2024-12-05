package org.iesch.fragmentos.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.iesch.fragmentos.R


    const val NOMBRE_BUNDLE = "nombre"
    const val DIRECCION_BUNDLE = "direccion"


class primerFragmento : Fragment() {

    private var nombre: String? = null
    private var direccion: String? = null


    //  Este método se llama cuando la vista se haya cargado
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  Oye! ¿Hay argumentos? (Con educación). Si hay alguno, ¿me lo puedes dar?
        arguments?.let {
            nombre = it.getString(NOMBRE_BUNDLE)
            direccion = it.getString(DIRECCION_BUNDLE)

            Log.i("DAM2", nombre.orEmpty())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primer_fragmento, container, false)
    }



    //  Los fragmentos se suelen instanciar con un método llamado newInstance
    //  Este método, lo único que hace, es devolver el fragment
    //  Desde donde quiera que llame a este fragment, le voy a pasar los parámetros que sea
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            primerFragmento().apply {
                //  Le estoy diciendo aue coja al atributo arguments y le voy a pasar un Bundle
                //  Un bundle es donde va a guardar toda la info que le vamos a pasar al Bundle
                arguments = Bundle().apply {
                    putString(NOMBRE_BUNDLE, nombre)
                    putString(DIRECCION_BUNDLE, direccion)
                }
            }
    }
}