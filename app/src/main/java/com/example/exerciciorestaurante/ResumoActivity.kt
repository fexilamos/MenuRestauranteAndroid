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

        val qtdTonkatsu = intent.getIntExtra("qtdTonkatsu", 0)
        val qtdKatsu = intent.getIntExtra("qtdKatsu", 0)
        val qtdOkonomiyaki = intent.getIntExtra("qtdOkonomiyaki", 0)
        val qtdGyudon = intent.getIntExtra("qtdGyudon", 0)

        if (qtdTonkatsu > 0) {
            val valor = qtdTonkatsu * 10
            resumo.append("Tonkatsu x$qtdTonkatsu - €$valor\n")
            total += valor
            binding.imgTonkatsu.visibility = View.VISIBLE
        }

        if (qtdKatsu > 0) {
            val valor = qtdKatsu * 10
            resumo.append("Katsu Sando x$qtdKatsu - €$valor\n")
            total += valor
            binding.imgKatsu.visibility = View.VISIBLE
        }

        if (qtdOkonomiyaki > 0) {
            val valor = qtdOkonomiyaki * 7
            resumo.append("Okonomiyaki x$qtdOkonomiyaki - €$valor\n")
            total += valor
            binding.imgOkonomiyaki.visibility = View.VISIBLE
        }

        if (qtdGyudon > 0) {
            val valor = qtdGyudon * 15
            resumo.append("Gyudon x$qtdGyudon - €$valor\n")
            total += valor
            binding.imgGyudon.visibility = View.VISIBLE
        }

        binding.txtResumo.text = resumo.toString()
        binding.txtTotal.text = "Total: €$total"
    }
}