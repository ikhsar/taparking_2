package com.example.taparking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taparking.DashboardActivity
import com.example.taparking.MainActivity
import com.example.taparking.RegisterActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Temukan elemen UI
        val registerTextView: TextView = findViewById(R.id.L_regis)
        val backImageView: ImageView = findViewById(R.id.L_back)
        val loginButton: Button = findViewById(R.id.l_btn_1)

        // Menangani klik untuk tombol Register
        registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Menangani klik untuk tombol Back
        backImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Menangani klik untuk tombol Login
        loginButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}
