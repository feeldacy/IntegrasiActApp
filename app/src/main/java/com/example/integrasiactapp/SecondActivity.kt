package com.example.integrasiactapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.integrasiactapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener{
            val usernameInput = binding.fieldUsername.text.toString()
            val passwordInput = binding.fieldPassword.text.toString()

            val savedUsername = sharedPreferences.getString("username", "")
            val savedPassword = sharedPreferences.getString("password", "")

            val savedFullname = sharedPreferences.getString("fullname", "")
            val savedEmail = sharedPreferences.getString("email", "")
            val savedPhone = sharedPreferences.getString("phone", "")
            val savedGender = sharedPreferences.getString("gender", "")

            if (usernameInput == savedUsername && passwordInput == savedPassword){
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("fullname", savedFullname)
                intent.putExtra("email", savedEmail)
                intent.putExtra("phone", savedPhone)
                intent.putExtra("gender", savedGender)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}