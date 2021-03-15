package com.example.meetinplace

import android.os.Bundle
import android.util.Log
import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.meetinplace.data.repository.MapRepositoryImpl
import com.example.meetinplace.data.source.remote.MapRemoteService
import com.example.meetinplace.databinding.ActivityMainBinding
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback


class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding
    private var mapRepositoryImpl: MapRepositoryImpl = MapRepositoryImpl()
    private lateinit var mapRemoteService: MapRemoteService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

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
                    Log.i(
                        "@@@@",
                        it.toString()
                    )
                },
                fail = {
                    Log.e("@@@@", it.toString())
                })
        }
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {

    }

    companion object {
        val TAG = MainActivity::class.qualifiedName
    }
}