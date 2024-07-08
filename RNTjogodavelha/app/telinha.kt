package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.delay

class telinha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViR.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = intent
            val j = Intent(this, PedidoActivity:: class.java)
            j.putExtras(i)
            startActivity(j)
        }, 2000)



    }
}