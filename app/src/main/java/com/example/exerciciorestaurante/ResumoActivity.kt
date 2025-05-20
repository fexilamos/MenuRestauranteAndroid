package com.example.exerciciorestaurante

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exerciciorestaurante.databinding.ActivityResumoBinding

class ResumoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResumoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resumo = StringBuilder()
        var total = 0

        // Tonkatsu
        if (intent.getBooleanExtra("tonkatsu", false)) {
            resumo.append("Tonkatsu - €10\n")
            total += 10
            binding.imgTonkatsu.visibility = View.VISIBLE
        }

        // Katsu Sando
        if (intent.getBooleanExtra("katsu", false)) {
            resumo.append("Katsu Sando - €10\n")
            total += 10
            binding.imgKatsu.visibility = View.VISIBLE
        }

        // Okonomiyaki
        if (intent.getBooleanExtra("okonomiyaki", false)) {
            resumo.append("Okonomiyaki - €7\n")
            total += 7
            binding.imgOkonomiyaki.visibility = View.VISIBLE
        }

        // Gyudon
        if (intent.getBooleanExtra("gyudon", false)) {
            resumo.append("Gyudon - €15\n")
            total += 15
            binding.imgGyudon.visibility = View.VISIBLE
        }

        binding.txtResumo.text = resumo.toString()
        binding.txtTotal.text = "Total: €$total"
    }
}
