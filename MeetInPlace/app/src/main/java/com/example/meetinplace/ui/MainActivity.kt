package com.example.meetinplace.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.meetinplace.R
import com.example.meetinplace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        binding.btnNaverMap.setOnClickListener {
            startActivity(Intent(this, NaverMapActivity::class.java))
        }

        binding.btnGoogleMap.setOnClickListener {
            startActivity(Intent(this, GoogleMapActivity::class.java))
        }
    }

    companion object {
        val TAG = MainActivity::class.qualifiedName
    }
}