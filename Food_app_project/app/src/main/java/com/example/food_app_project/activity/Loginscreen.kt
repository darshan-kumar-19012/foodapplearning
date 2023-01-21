package com.example.food_app_project.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.food_app_project.databinding.ActivityLoginScreenBinding

class Loginscreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var phoneno : EditText
    private lateinit var password : EditText
    private lateinit var loginbutton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        val view = binding.root
        this.supportActionBar?.hide()
        setContentView(view)
        phoneno = binding.editTextPhoneNo
        password = binding.editTextTextPassword
        loginbutton = binding.buttonLogin
        loginbutton.setOnClickListener(){
            if(phoneno.text.toString() == "7904785732" && password.text.toString() == "password"){
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}