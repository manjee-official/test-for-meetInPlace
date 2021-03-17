package com.example.meetinplace.ui

import android.os.Bundle
import android.util.Log
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.meetinplace.R
import com.example.meetinplace.data.repository.MapRepositoryImpl
import com.example.meetinplace.databinding.ActivityNaverMapBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*

class NaverMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityNaverMapBinding
    private var mapRepositoryImpl: MapRepositoryImpl = MapRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@NaverMapActivity, R.layout.activity_main)

        val fm = supportFragmentManager
        val options = NaverMapOptions().mapType(NaverMap.MapType.Navi).nightModeEnabled(true)
            .indoorEnabled(true)
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance(options).also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }

        mapFragment.getMapAsync(this)

        binding.btnSearch.setOnClickListener {
            mapRepositoryImpl.searchAddressOnRemote(
                binding.etSearchAddress.text.toString(),
                success = {
                    Log.i(TAG, "API 호출 성공: $it.toString()")
                },
                fail = {
                    Log.e(TAG, "API 호출 실패: $it.toString()")
                })
        }
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        val cameraPosition = CameraPosition(LatLng(37.487936, 126.825071), 17.0)
        naverMap.cameraPosition = cameraPosition
    }

    companion object {
        val TAG = NaverMapActivity::class.qualifiedName
    }
}