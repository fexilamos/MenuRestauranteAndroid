package com.example.exerciciorestaurante

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exerciciorestaurante.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tonkatsu = intent.getBooleanExtra("tonkatsu", false)
        val katsu = intent.getBooleanExtra("katsu", false)
        val okonomiyaki = intent.getBooleanExtra("okonomiyaki", false)
        val gyudon = intent.getBooleanExtra("gyudon", false)

        Handler(Looper.getMainLooper()).postDelayed({
            val nextIntent = Intent(this, ResumoActivity::class.java).apply {
                putExtra("tonkatsu", tonkatsu)
                putExtra("katsu", katsu)
                putExtra("okonomiyaki", okonomiyaki)
                putExtra("gyudon", gyudon)
            }
            startActivity(nextIntent)
            finish()
        }, 4000)
    }
}
