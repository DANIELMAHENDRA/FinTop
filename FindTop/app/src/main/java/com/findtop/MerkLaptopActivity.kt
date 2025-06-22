package com.findtop

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MerkLaptopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merk_laptop)

        // Tombol back
        val backIcon = findViewById<ImageView>(R.id.back_icon)
        backIcon.setOnClickListener {
            onBackPressed() // Kembali ke halaman sebelumnya
        }

        val merk = intent.getStringExtra("merk")

        val image1 = findViewById<ImageView>(R.id.imageLaptop1)
        val image2 = findViewById<ImageView>(R.id.imageLaptop2)
        val image3 = findViewById<ImageView>(R.id.imageLaptop3)
        val title1 = findViewById<TextView>(R.id.textLaptop1)
        val title2 = findViewById<TextView>(R.id.textLaptop2)
        val title3 = findViewById<TextView>(R.id.textLaptop3)
        val price1 = findViewById<TextView>(R.id.textPrice1)
        val price2 = findViewById<TextView>(R.id.textPrice2)
        val price3 = findViewById<TextView>(R.id.textPrice3)

        when (merk) {
            "ASUS" -> {
                image1.setImageResource(R.drawable.a1)
                image2.setImageResource(R.drawable.a2)
                image3.setImageResource(R.drawable.a3)
                title1.text = "ASUS Zenbook 14"
                title2.text = "ASUS Vivbok Go"
                title3.text = "ASUS Vivbok Ge"
                price1.text = "Rp13.499.000"
                price2.text = "Rp9.899.000"
                price3.text = "Rp7.899.000"
            }
            "Acer" -> {
                image1.setImageResource(R.drawable.a3)
                image2.setImageResource(R.drawable.a2)
                image3.setImageResource(R.drawable.a3)
                title1.text = "Acer Aspire 5"
                title2.text = "Acer Swift X"
                title3.text = "Acer Swift y"
                price1.text = "Rp11.799.000"
                price2.text = "Rp14.199.000"
                price3.text = "Rp12.199.000"
            }
            "Lenovo" -> {
                image1.setImageResource(R.drawable.a2)
                image2.setImageResource(R.drawable.a1)
                image3.setImageResource(R.drawable.a3)
                title1.text = "Lenovo IdeaPad Slim"
                title2.text = "Lenovo Legion 5"
                title3.text = "Lenovo Yoga Slim"
                price1.text = "Rp9.599.000"
                price2.text = "Rp17.299.000"
                price3.text = "Rp13.899.000"
            }
            else -> {
                title1.text = "Laptop tidak ditemukan"
                title2.text = "Laptop tidak ditemukan"
                title3.text = "Laptop tidak ditemukan"
                price1.text = "-"
                price2.text = "-"
                price3.text = "-"
            }
        }
    }
}
