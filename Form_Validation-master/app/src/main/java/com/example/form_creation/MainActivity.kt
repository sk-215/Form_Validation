package com.example.form_creation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val message = "Invalid credentials"
        val userId: EditText = findViewById(R.id.username_edittext)
        val pass: EditText = findViewById(R.id.password_edittext)
        val btn: Button = findViewById(R.id.sign_in_button)
        val reset: Button = findViewById(R.id.rebt)

        btn.setOnClickListener {
            val finUserId = userId.text.toString()
            val finPass = pass.text.toString()
            val check1 = "[a-zA-z]+".toRegex()
            val check2 = "\\d{4}".toRegex()
            if (check1.matches(finUserId) && check2.matches((finPass))){
                val intent = Intent(this,welcome_page::class.java)
                    .putExtra("username",finUserId)
                    .putExtra("password",finPass)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
            }
        }
        reset.setOnClickListener {
            userId.text = null
            pass.text = null
        }
    }
}

