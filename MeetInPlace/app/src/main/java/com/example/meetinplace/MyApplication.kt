package com.example.meetinplace

import android.app.Application
import com.naver.maps.map.NaverMapSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        NaverMapSdk.getInstance(this).client = NaverMapSdk.NaverCloudPlatformClient(API_ID)
    }

    companion object {
        const val API_ID = "mbin844jaa"
        const val API_KEY = "nYzVgBFBy14pe15HQpo7a8ZAmwMIK4F49amHe0ki"
    }
}