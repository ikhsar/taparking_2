package com.example.taparking

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.taparking.BookingActivity
import com.example.taparking.HistoryActivity
import com.example.taparking.LocationActivity
import com.example.taparking.PayActivity
import com.example.taparking.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val payImageView: ImageView = findViewById(R.id.d_pay)
        val locationImageView: ImageView = findViewById(R.id.d_location)
        val bookingImageView: ImageView = findViewById(R.id.d_booking)
        val historyImageView: ImageView = findViewById(R.id.d_history)


        payImageView.setOnClickListener {
            val intent = Intent(this, PayActivity::class.java)
            startActivity(intent)
        }

        locationImageView.setOnClickListener {
            val intent = Intent(this, LayoutParkiranActivity::class.java)
            startActivity(intent)
        }

        bookingImageView.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            startActivity(intent)
        }

        historyImageView.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
