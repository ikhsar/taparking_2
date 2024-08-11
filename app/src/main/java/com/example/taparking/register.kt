package com.example.taparking

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private var isPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val auth = FirebaseAuth.getInstance()
        val loginTextView: TextView = findViewById(R.id.RL)
        val backImageView: ImageView = findViewById(R.id.R_back)
        val eyeIcon1: ImageView = findViewById(R.id.r_mata1)
        val eyeIcon2: ImageView = findViewById(R.id.r_mata2)
        val passwordEditText: EditText = findViewById(R.id.r_password)
        val confirmPasswordEditText: EditText = findViewById(R.id.r_confirm)

        fun registerUser(email: String, password: String) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val user = auth.currentUser

                    } else {

                        Log.w("Register", "createUserWithEmail:failure", task.exception)
                    }
                }
        }



        loginTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        backImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        eyeIcon1.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                eyeIcon1.setImageResource(R.drawable.mata1)
            } else {
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                eyeIcon1.setImageResource(R.drawable.mata2)
            }
            passwordEditText.setSelection(passwordEditText.text.length)
        }

        eyeIcon2.setOnClickListener {
            isConfirmPasswordVisible = !isConfirmPasswordVisible
            if (isConfirmPasswordVisible) {
                confirmPasswordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                eyeIcon2.setImageResource(R.drawable.mata1)
            } else {
                confirmPasswordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                eyeIcon2.setImageResource(R.drawable.mata2)
            }
            confirmPasswordEditText.setSelection(confirmPasswordEditText.text.length)
        }
    }
}
