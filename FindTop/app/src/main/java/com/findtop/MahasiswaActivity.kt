package com.findtop

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MahasiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mahasiswa)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        tombol kembali
        val backIcon = findViewById<ImageView>(R.id.back_icon)
        backIcon.setOnClickListener {
            onBackPressed() // atau finish() jika tidak ingin kembali ke stack sebelumnya
        }

        // Tombol filter Merk
        val buttonMerk: LinearLayout = findViewById(R.id.buttonMerk)
        buttonMerk.setOnClickListener {
            val intent = Intent(this, MerkActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Membuka tampilan Merk...", Toast.LENGTH_SHORT).show()
        }

        // Tombol filter Pengguna
        val buttonPengguna: LinearLayout = findViewById(R.id.buttonPengguna)
        buttonPengguna.setOnClickListener {
            val intent = Intent(this, PenggunaActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Membuka tampilan Pengguna...", Toast.LENGTH_SHORT).show()
        }

        // Tombol filter Harga (menampilkan Bottom Sheet)
        val buttonHarga: LinearLayout = findViewById(R.id.buttonHarga)
        buttonHarga.setOnClickListener {
            val filterBottomSheet = FilterSortBottomSheet()
            filterBottomSheet.show(supportFragmentManager, filterBottomSheet.tag)
            Toast.makeText(this, "Menampilkan filter harga...", Toast.LENGTH_SHORT).show()
        }

    }
}