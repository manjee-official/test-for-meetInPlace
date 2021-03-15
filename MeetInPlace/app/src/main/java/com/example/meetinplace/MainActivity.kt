package com.example.meetinplace

import android.os.Bundle
import android.util.Log
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
		val options = NaverMapOptions().mapType(NaverMap.MapType.Navi).nightModeEnabled(true).indoorEnabled(true)
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance(options).also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }

		mapFragment.getMapAsync(this)
    }

	@UiThread
    override fun onMapReady(naverMap: NaverMap) {

    }

    companion object {
        val TAG = MainActivity::class.qualifiedName
    }
}