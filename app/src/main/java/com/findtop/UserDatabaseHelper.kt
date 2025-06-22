package com.findtop

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class UserDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "user_db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nama_lengkap TEXT,
                email TEXT,
                username TEXT,
                password TEXT
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    // ✅ Menyimpan user baru
    fun insertUser(nama: String, email: String, username: String, password: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("nama_lengkap", nama)
            put("email", email)
            put("username", username)
            put("password", password)
        }
        return db.insert("users", null, values) != -1L
    }

    // ✅ Cek login
    fun checkUser(username: String, password: String): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM users WHERE username=? AND password=?",
            arrayOf(username, password)
        )
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }

    // ✅ Cek apakah username sudah ada
    fun checkUsernameExists(username: String): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM users WHERE username = ?",
            arrayOf(username)
        )
        val exists = cursor.moveToFirst()
        cursor.close()
        return exists
    }

    // ✅ Log semua user ke Logcat
    fun logAllUsers() {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users", null)
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val nama = cursor.getString(cursor.getColumnIndexOrThrow("nama_lengkap"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            val username = cursor.getString(cursor.getColumnIndexOrThrow("username"))
            Log.d("USER_DB", "ID: $id, Nama: $nama, Email: $email, Username: $username")
        }
        cursor.close()
    }

    // ✅ (Opsional) Ambil semua user sebagai list string
    fun getAllUsers(): List<String> {
        val list = mutableListOf<String>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users", null)
        while (cursor.moveToNext()) {
            val nama = cursor.getString(cursor.getColumnIndexOrThrow("nama_lengkap"))
            val username = cursor.getString(cursor.getColumnIndexOrThrow("username"))
            list.add("👤 $nama (@$username)")
        }
        cursor.close()
        return list
    }
}
