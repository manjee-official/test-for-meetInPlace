package com.example.meetinplace.ui

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.meetinplace.R
import com.example.meetinplace.databinding.ActivityDaumMapBinding
import net.daum.mf.map.api.MapView


class KakaoMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaumMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this@KakaoMapActivity, R.layout.activity_daum_map)

        val mapView = MapView(this)

        val mapViewContainer = binding.mapView as ViewGroup
        mapViewContainer.addView(mapView)
    }
}