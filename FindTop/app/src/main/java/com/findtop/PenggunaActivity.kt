package com.findtop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PenggunaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengguna)

        // ============ Tombol Back ============
        val backIcon = findViewById<ImageView>(R.id.back_icon)
        backIcon.setOnClickListener {
            onBackPressed() // atau finish()
        }

        // ============ Tambahan aksi tombol Merk ============
        val buttonMerk = findViewById<Button>(R.id.buttonMerk)
        buttonMerk.setOnClickListener {
            // Pindah ke MerkActivity
            val intent = Intent(this@PenggunaActivity, MerkActivity::class.java)
            startActivity(intent)
        }

        // ============ Kategori Pengguna ============
        val kategoriList = listOf(
            "Pelajar/Mahasiswa",
            "Pekerja",
            "Programer",
            "Streamer"
        )

        val containerKategori = findViewById<LinearLayout>(R.id.containerKategori)
        val inflater = LayoutInflater.from(this)

        kategoriList.forEach { kategori ->
            val view = inflater.inflate(R.layout.item_kategori, containerKategori, false)
            val text = view.findViewById<TextView>(R.id.textKategori)
            text.text = kategori

            view.setOnClickListener {
                when (kategori) {
                    "Pelajar/Mahasiswa" -> startActivity(Intent(this, MahasiswaActivity::class.java))
                    "Pekerja" -> startActivity(Intent(this, PekerjaActivity::class.java))
                    "Programer" -> startActivity(Intent(this, ProgramerActivity::class.java))
                    "Streamer" -> startActivity(Intent(this, StreamerActivity::class.java))
                }
            }

            containerKategori.addView(view)
        }
    }
}
