package com.findtop

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailLaptopActivity : AppCompatActivity() {

    private var isLoved = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_laptop)

        val btnWishlist = findViewById<ImageView>(R.id.btnWishlist)

        btnWishlist.setOnClickListener {
            isLoved = !isLoved
            if (isLoved) {
                btnWishlist.setImageResource(R.drawable.ic_love_filled)
            } else {
                btnWishlist.setImageResource(R.drawable.ic_love_outline)
            }
        }

        findViewById<ImageView>(R.id.back_icon).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Ambil data dari intent
        val nama = intent.getStringExtra("nama")
        val harga = intent.getStringExtra("harga")
        val gambar = intent.getIntExtra("gambar", R.drawable.laptop1)
        val spesifikasi = intent.getStringExtra("spesifikasi")

        // Tampilkan data
        findViewById<TextView>(R.id.textDetailNama).text = nama
        findViewById<TextView>(R.id.textDetailHarga).text = harga
        findViewById<ImageView>(R.id.imageDetail).setImageResource(gambar)
        findViewById<TextView>(R.id.textDetailSpesifikasi).text = spesifikasi
    }
}