package com.findtop

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val backBtn = findViewById<ImageButton>(R.id.btnBack)
        backBtn.setOnClickListener {
            finish()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewNotif)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotificationAdapter(getDummyNotifications())
    }

    private fun getDummyNotifications(): List<Int> {
        // Kita pakai list kosong untuk memunculkan 5 item dummy
        return listOf(1, 2, 3, 4, 5)
    }
}