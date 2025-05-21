package com.example.exerciciorestaurante

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exerciciorestaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Tonkastu.setOnCheckedChangeListener { _, isChecked ->
            binding.quantidadeTonkatsu.isEnabled = isChecked
        }

        binding.checkKatsu.setOnCheckedChangeListener { _, isChecked ->
            binding.quantidadeKatsu.isEnabled = isChecked
        }

        binding.checkOkonomiyaki.setOnCheckedChangeListener { _, isChecked ->
            binding.quantidadeOkonomiyaki.isEnabled = isChecked
        }

        binding.checkGyudon.setOnCheckedChangeListener { _, isChecked ->
            binding.quantidadeGyudon.isEnabled = isChecked
        }

        binding.btnPedido.setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java).apply {
                putExtra("tonkatsu", binding.Tonkastu.isChecked)
                putExtra("katsu", binding.checkKatsu.isChecked)
                putExtra("okonomiyaki", binding.checkOkonomiyaki.isChecked)
                putExtra("gyudon", binding.checkGyudon.isChecked)

                putExtra("qtdTonkatsu", binding.quantidadeTonkatsu.text.toString().toIntOrNull() ?: 0)
                putExtra("qtdKatsu", binding.quantidadeKatsu.text.toString().toIntOrNull() ?: 0)
                putExtra("qtdOkonomiyaki", binding.quantidadeOkonomiyaki.text.toString().toIntOrNull() ?: 0)
                putExtra("qtdGyudon", binding.quantidadeGyudon.text.toString().toIntOrNull() ?: 0)
            }
            startActivity(intent)
        }
    }
}