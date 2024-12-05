package org.iesch.cine

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.cine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.spiderman.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.spiderman)
        }

        binding.batman.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.batman)
        }

        binding.superman.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.superman)
        }

        binding.XMen.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.xmen)
        }

        binding.IronMan.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.ironman)
        }

        binding.Interestelar.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.interestelar)
        }
    }
}