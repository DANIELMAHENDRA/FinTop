package com.findtop

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dbHelper = UserDatabaseHelper(this)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirm = findViewById<EditText>(R.id.etConfirmPassword)
        val btnDaftar = findViewById<Button>(R.id.btnDaftar)
        val tvMasuk = findViewById<TextView>(R.id.tvMasuk)

        btnDaftar.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirm.text.toString()

            if (nama.isBlank() || email.isBlank() || username.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Format email tidak valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (dbHelper.checkUsernameExists(username)) {
                Toast.makeText(this, "Username sudah terdaftar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val inserted = dbHelper.insertUser(nama, email, username, password)
            if (inserted) {
                Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()

                // ✅ Ini yang penting: cetak semua user ke Logcat
                dbHelper.logAllUsers()

                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Pendaftaran gagal", Toast.LENGTH_SHORT).show()
            }
        }

        tvMasuk.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
