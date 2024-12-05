package org.iesch.a03_ciclodevida

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("CICLO_DE_VIDA", "Entramos en el metodo onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLO_DE_VIDA", "Entramos en el metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLO_DE_VIDA", "Entramos en el metodo onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO_DE_VIDA", "Entramos en el metodo onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLO_DE_VIDA", "Entramos en el metodo onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO_DE_VIDA", "Entramos en el metodo onDestroy")
    }
}