package com.findtop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnMasuk = findViewById<Button>(R.id.btnMasuk)
        val btnDaftar = findViewById<Button>(R.id.btnDaftar)

        btnMasuk.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnDaftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
