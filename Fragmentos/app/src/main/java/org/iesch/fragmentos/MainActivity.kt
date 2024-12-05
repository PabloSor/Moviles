package org.iesch.fragmentos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import org.iesch.fragmentos.fragments.DIRECCION_BUNDLE
import org.iesch.fragmentos.fragments.NOMBRE_BUNDLE
import org.iesch.fragmentos.fragments.primerFragmento

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

        if (savedInstanceState == null) {
            val bundle = bundleOf(
                NOMBRE_BUNDLE to "Pablo",
                DIRECCION_BUNDLE to "TERUEL"
            )

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<primerFragmento>(R.id.fragment_container)
            }
        }
    }
}