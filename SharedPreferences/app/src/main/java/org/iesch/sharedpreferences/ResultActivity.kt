package org.iesch.sharedpreferences

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.sharedpreferences.UserVipAplication.Companion.preferencias
import org.iesch.sharedpreferences.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resultConstraint)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initUI()

        binding.btnCerrar.setOnClickListener {
            preferencias.borrarTodo()
            onBackPressedDispatcher.onBackPressed()
        }

    }

    private fun initUI() {
        val userName = preferencias.obtenerNombre()
        binding.tvNombre.text = "Bienvenido $userName"

        val userEmail = preferencias.obtenerEmail()
        binding.tvEmail.text = userEmail

        if (preferencias.obtenerVip()){
            setColorBackground()
        }
    }

    private fun setColorBackground() {
        binding.resultConstraint.setBackgroundColor(ContextCompat.getColor(this, R.color.vipColor))
    }

}