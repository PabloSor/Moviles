package org.iesch.registrosuperheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.registrosuperheroes.databinding.ActivityMainBinding
import org.iesch.registrosuperheroes.model.Hero
import java.io.File

class MainActivity : AppCompatActivity() {

    private var CAMERA_KEY = 1000
    private lateinit var heroImage: ImageView
    private var heroBitmap: Bitmap? = null

    private var pictureFullPath = ""

    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()){
        success ->
        if (success && pictureFullPath.isNotEmpty()){
            heroBitmap = BitmapFactory.decodeFile(pictureFullPath)
            heroImage.setImageBitmap(heroBitmap)
        }
    }

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

        heroImage = binding.superheroImage
        heroImage.setOnClickListener{
            openCamera()
        }


        binding.saveButton.setOnClickListener {
            val superHeroName = binding.heroname.text.toString()
            val alterEgo = binding.alterego.text.toString()
            val bio = binding.bio.text.toString()
            val power = binding.ratingbar.rating

            val heroe = Hero(superHeroName, alterEgo, bio, power)

            openDetailActivity(heroe)
        }
    }

    private fun openCamera(){
        val imageFile = createImageFile()
        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            FileProvider.getUriForFile(this, "$packageName.provider", imageFile)

        }else{
            Uri.fromFile(imageFile)
        }

        getContent.launch(uri)
    }

    private fun createImageFile(): File {
        val fileName = "superhero_image"
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File.createTempFile(fileName, ".jpg", fileDirectory)
        pictureFullPath = file.absolutePath
        return file
    }

    private fun openDetailActivity(heroe: Hero) {
        val intent = Intent(this, RegisterActivity2::class.java)


        intent.putExtra(RegisterActivity2.HERO_KEY, heroe)
        intent.putExtra(RegisterActivity2.PHOTO_KEY, pictureFullPath)

        startActivity(intent)
    }
}