package com.example.integrasiactapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.integrasiactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        binding.btnRegister.setOnClickListener {
            val fullnameInput = binding.fieldFullname.text.toString()
            val usernameInput = binding.fieldUsername.text.toString()
            val emailInput = binding.fieldEmail.text.toString()
            val phoneInput = binding.fieldPhone.text.toString()
            val genderInput = binding.fieldGender.text.toString()
            val passwordInput = binding.fieldPassword.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("fullname", fullnameInput)
            editor.putString("username", usernameInput)
            editor.putString("email", emailInput)
            editor.putString("phone", phoneInput)
            editor.putString("gender", genderInput)
            editor.putString("password", passwordInput)
            editor.apply()


            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}