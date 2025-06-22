package com.findtop

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailWhishActivity : AppCompatActivity() {
    private var isLoved = true  // diasumsikan dari Wishlist (sudah loved)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_whish)

        val backIcon = findViewById<ImageView>(R.id.back_icon)
        backIcon.setOnClickListener {
            onBackPressed()
        }

        // Ambil data dari intent
        val nama = intent.getStringExtra("nama")
        val harga = intent.getStringExtra("harga")
        val gambar = intent.getIntExtra("gambar", R.drawable.laptop1)
        val spesifikasi = intent.getStringExtra("spesifikasi")

        // Temukan view dan isi datanya
        findViewById<TextView>(R.id.textDetailNama).text = nama
        findViewById<TextView>(R.id.textDetailHarga).text = harga
        findViewById<ImageView>(R.id.imageDetail).setImageResource(gambar)
        findViewById<TextView>(R.id.textDetailSpesifikasi).text = spesifikasi

        // Tombol wishlist toggle
        val btnWishlist = findViewById<ImageView>(R.id.btnWishlist)
        btnWishlist.setOnClickListener {
            isLoved = !isLoved
            if (isLoved) {
                btnWishlist.setImageResource(R.drawable.ic_love_filled)
            } else {
                btnWishlist.setImageResource(R.drawable.ic_love_outline)
            }
        }
    }
}