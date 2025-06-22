package com.findtop

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var dbHelper: UserDatabaseHelper
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dbHelper = UserDatabaseHelper(this)
        sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)

        val etUser = findViewById<EditText>(R.id.etUsername)
        val etPass = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvDaftar = findViewById<TextView>(R.id.tvDaftar)

        btnLogin.setOnClickListener {
            val user = etUser.text.toString().trim()
            val pass = etPass.text.toString().trim()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Isi username dan password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (dbHelper.checkUser(user, pass)) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()

                // ✅ Simpan username login ke SharedPreferences
                sharedPref.edit().putString("username", user).apply()

                // ✅ Tampilkan semua user di Logcat
                dbHelper.logAllUsers()

                // ✅ Pindah ke MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // ✅ Arahkan ke halaman register saat klik teks "Daftar"
        tvDaftar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}