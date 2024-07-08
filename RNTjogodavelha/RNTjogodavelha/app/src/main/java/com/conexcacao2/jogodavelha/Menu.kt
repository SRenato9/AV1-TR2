package com.conexcacao2.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.conexcacao2.jogodavelha.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //Quando o botão da máquina é clicado, ele abre a atividade máquina.
        binding.btMaquina.setOnClickListener {
            val intent = Intent(this, maquina::class.java)
            startActivity(intent)
        }

        //Quando o botão do jogo da velha é clicado, ele abre a atividade principal do jogo da velha.
        binding.btJogodavelha.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}