package com.conexcacao2.jogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.conexcacao2.jogodavelha.databinding.ActivityMainBinding
import com.conexcacao2.jogodavelha.databinding.ActivityMenuBinding


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

 

    private lateinit var binding: ActivityMainBinding

    //Uma representação do tabuleiro do jogo da velha.
    val tabuleiro = arrayOf(
        arrayOf("1", "2", "3"),
        arrayOf("4", "5", "6"),
        arrayOf("7", "8", "9")
    )

    //Identificando o Jogador que está jogando.
    var jogadorRecente = "X"


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
    }

    //Função que está conectada ao view.
    fun buttonClick(view: View) {
        //Uma constante que está ligada a um botão que foi clicado.
        val buttonEscolhido = view as Button
        //O botão recebe o jogador que está jogando recentemente.
        buttonEscolhido.text = jogadorRecente

        //Matriz para ajudar a identificar onde o jogador clicou.
        when (buttonEscolhido.id) {
            binding.buttonUm.id -> tabuleiro[0][0] = jogadorRecente
            binding.buttonDois.id -> tabuleiro[0][1] = jogadorRecente
            binding.buttonTres.id -> tabuleiro[0][2] = jogadorRecente
            binding.buttonQuatro.id -> tabuleiro[1][0] = jogadorRecente
            binding.buttonCinco.id -> tabuleiro[1][1] = jogadorRecente
            binding.buttonSeis.id -> tabuleiro[1][2] = jogadorRecente
            binding.buttonSete.id -> tabuleiro[2][0] = jogadorRecente
            binding.buttonOito.id -> tabuleiro[2][1] = jogadorRecente
            binding.buttonNove.id -> tabuleiro[2][2] = jogadorRecente

            // Adicionar um atraso antes da jogada do computador
            Handler().postDelayed({
                jogadaComputador()
            }, delay Millis; 500) // Atraso de segundos (alguns milissegundos)
        }


        //Varíavel que recebe o jogador vencedor.
        var vencedor = verificaVencedor(tabuleiro)
        if (!vencedor.isNullOrBlank()){
            Toast.makeText(this,"vencedor: " + vencedor, Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //Condição para identificar quando o jogador será x e quando ele será O.
        if (jogadorRecente.equals("X")) {
            buttonEscolhido.setBackgroundResource(R.drawable.-removebg.png)
            jogadorRecente = "O"
        } else {
            buttonEscolhido.setBackgroundResource(R.drawable.caveira-removebg-preview.png)
            jogadorRecente = "X"
        }
        buttonEscolhido.isEnabled = false
    }
    //Função que tem como objetivo verificar o vencedor.
    fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {
        for (i in 0 until 3) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0]
            }
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return tabuleiro[0][i]
            }
        }
        //Confere as posições diagonais.
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0]
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2]
        }
        //Confere a quantidade de jogadores do jogo.
        var empate = 0
        for (linha in tabuleiro) {
            for (valor in linha) {
                if (valor.equals("X") || valor.equals("O")) {
                    empate++
                }
            }
        }
        //Uma condição identificando que quando não houver três letras iguais, haverá sido empate.
        if (empate == 9) {
            return "Empate"
        }
        //Retorna nulo
        return null

        //Botão de Volta a tela Menu.
        binding.btVoltar.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
            finish()
        }

        //Botão de Fechamento da atividade.
        binding.btSair.setOnClickListener {
            finishAffinity( )

        }
    }



}

