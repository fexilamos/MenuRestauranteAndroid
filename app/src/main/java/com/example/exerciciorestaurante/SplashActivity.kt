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

        val extras = intent.extras

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ResumoActivity::class.java)
            intent.putExtras(extras ?: Bundle())
            startActivity(intent)
            finish()
        }, 4000)
    }
}
