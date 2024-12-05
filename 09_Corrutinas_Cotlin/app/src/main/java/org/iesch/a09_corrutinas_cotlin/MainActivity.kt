package org.iesch.a09_corrutinas_cotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.iesch.a09_corrutinas_cotlin.retrofit.RetrofitHelper

class MainActivity : AppCompatActivity() {

    val retrofit = RetrofitHelper.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       lifecycleScope.launch(Dispatchers.IO){
           val response = retrofit.getSuperHeroes("a")
           withContext(Dispatchers.Main) {
               if (response.isSuccessful) {
                   Toast.makeText(this@MainActivity, "Funciona", Toast.LENGTH_SHORT).show()
               }
           }
       }

        fun waitForCoroutines(){
            lifecycleScope.launch(Dispatchers.IO) {
                val deferreds = listOf(
                    async { retrofit.getSuperHeroes("a") },
                    async { retrofit.getSuperHeroes("b") },
                    async { retrofit.getSuperHeroes("c") },
                    async { retrofit.getSuperHeroes("d") },
                )
                val response = deferreds.awaitAll()
            }
        }

    }
}