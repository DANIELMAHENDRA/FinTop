package com.findtop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MerkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merk)

//        tombol kembali
        val backIcon = findViewById<ImageView>(R.id.back_icon)
        backIcon.setOnClickListener {
            onBackPressed() // atau finish() jika tidak ingin kembali ke stack sebelumnya
        }

        // Tombol navigasi ke PenggunaActivity
        val buttonPengguna = findViewById<Button>(R.id.buttonPengguna)
        buttonPengguna.setOnClickListener {
            val intent = Intent(this@MerkActivity, PenggunaActivity::class.java)
            startActivity(intent)
        }

        // Layout klik merk ASUS
        val asus = findViewById<LinearLayout>(R.id.asus)
        asus.setOnClickListener {
            val intent = Intent(this@MerkActivity, MerkLaptopActivity::class.java)
            intent.putExtra("merk", "ASUS")
            startActivity(intent)
        }

        // Layout klik merk Acer
        val acer = findViewById<LinearLayout>(R.id.acer)
        acer.setOnClickListener {
            val intent = Intent(this@MerkActivity,MerkLaptopActivity::class.java)
            intent.putExtra("merk", "Acer")
            startActivity(intent)
        }

        // Layout klik merk Acer
        val lenovo = findViewById<LinearLayout>(R.id.lenovo)
        lenovo.setOnClickListener {
            val intent = Intent(this@MerkActivity,MerkLaptopActivity::class.java)
            intent.putExtra("merk", "Lenovo")
            startActivity(intent)
        }

        // Tambahkan merk lain jika ada (misalnya Lenovo, HP, Dell, dll)
        // val lenovo = findViewById<LinearLayout>(R.id.lenovo)
        // lenovo.setOnClickListener {
        //     val intent = Intent(this@MerkActivity, LaptopByMerkActivity::class.java)
        //     intent.putExtra("merk", "Lenovo")
        //     startActivity(intent)
        // }
    }
}
