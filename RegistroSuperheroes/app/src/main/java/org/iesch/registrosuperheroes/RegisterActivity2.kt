package org.iesch.registrosuperheroes

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.registrosuperheroes.databinding.ActivityRegister2Binding
import org.iesch.registrosuperheroes.model.Hero

class RegisterActivity2 : AppCompatActivity() {

    companion object {
        const val HERO_NAME_KEY = "hero"
        const val ALTER_EGO_KEY = "alter_ego"
        const val BIO_KEY = "bio"
        const val RANDING_KEY = "power"
        const val HERO_KEY = "hero"
        const val PHOTO_KEY = "photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityRegister2Binding.inflate(layoutInflater);
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val extras:Bundle = intent.extras!!

        val superHero = extras.getParcelable<Hero>(HERO_KEY)!!
        //val bitmap = bundle.getParcelable<Bitmap>(PHOTO_KEY)!!
        val imagePath = extras.getString(PHOTO_KEY)
        val bitmap = BitmapFactory.decodeFile(imagePath)

        binding.Nombre2.text = superHero.name
        binding.AlterEgo2.text = superHero.alterEgo
        binding.bio2.text = superHero.bio
        binding.ratingbar2.rating = superHero.power

        if (bitmap != null){
            binding.imageView2.setImageBitmap(bitmap)
        }
        binding.imageView2.setImageBitmap(bitmap)
    }
}