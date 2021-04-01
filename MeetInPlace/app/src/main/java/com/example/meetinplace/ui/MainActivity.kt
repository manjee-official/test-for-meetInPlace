package com.example.meetinplace.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.meetinplace.R
import com.example.meetinplace.databinding.ActivityMainBinding
import java.security.MessageDigest

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

        binding.btnImageTest.setOnClickListener {
            startActivity(Intent(this, ImageTestActivity::class.java))
        }

        binding.btnKakaoMap.setOnClickListener {
            startActivity(Intent(this, KakaoMapActivity::class.java))
        }
    }

    companion object {
        val TAG = MainActivity::class.qualifiedName
    }
}