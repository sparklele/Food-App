package com.example.foodapp2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.foodapp2.databinding.ActivityLoginBinding

class ActivityLogin : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        binding.loginBT.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            if(intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }
    }
}
