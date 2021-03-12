package com.example.meetinplace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMapSdk
import com.naver.maps.map.NaverMapSdk.NaverCloudPlatformClient


class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val fm = supportFragmentManager
		val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
			?: MapFragment.newInstance().also {
				fm.beginTransaction().add(R.id.map, it).commit()
			}
	}
}