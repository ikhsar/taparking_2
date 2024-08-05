package com.example.taparking

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taparking.DashboardActivity
import com.example.taparking.MainActivity
import com.example.taparking.RegisterActivity
import com.example.taparking.R

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var showPasswordImageView: ImageView
    private lateinit var rememberMeCheckBox: CheckBox
    private lateinit var forgotPasswordTextView: TextView
    private lateinit var loginButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        emailEditText = findViewById(R.id.l_email)
        passwordEditText = findViewById(R.id.l_password)
        showPasswordImageView = findViewById(R.id.l_mata)
        rememberMeCheckBox = findViewById(R.id.l_checkbox)
        forgotPasswordTextView = findViewById(R.id.txt_l_forgot)
        loginButton = findViewById(R.id.l_btn_1)


        sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE)


        rememberMeCheckBox.isChecked = sharedPreferences.getBoolean("rememberMe", false)
        if (rememberMeCheckBox.isChecked) {
            emailEditText.setText(sharedPreferences.getString("email", ""))
            passwordEditText.setText(sharedPreferences.getString("password", ""))
        }


        showPasswordImageView.setOnClickListener {
            if (passwordEditText.inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT
                showPasswordImageView.setImageResource(R.id.l_mata)
            } else {
                passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                showPasswordImageView.setImageResource(R.id.l_mata)
            }
            passwordEditText.setSelection(passwordEditText.text.length)
        }




        val registerTextView: TextView = findViewById(R.id.L_regis)
        registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        val backImageView: ImageView = findViewById(R.id.L_back)
        backImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        loginButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()

        if (rememberMeCheckBox.isChecked) {
            val editor = sharedPreferences.edit()
            editor.putBoolean("rememberMe", true)
            editor.putString("email", emailEditText.text.toString())
            editor.putString("password", passwordEditText.text.toString())
            editor.apply()
        } else {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }
    }
}
