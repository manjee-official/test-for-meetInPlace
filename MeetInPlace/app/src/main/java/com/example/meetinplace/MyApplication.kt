package com.example.meetinplace

import android.app.Application
import com.naver.maps.map.NaverMapSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        NaverMapSdk.getInstance(this).client = NaverMapSdk.NaverCloudPlatformClient(NAVER_API_ID)
    }

    companion object {
        const val NAVER_API_ID = "mbin844jaa"
        const val NAVER_API_KEY = "nYzVgBFBy14pe15HQpo7a8ZAmwMIK4F49amHe0ki"
        const val KAKAO_API_KEY = "KakaoAK 605eb0c04e76f7dd0c3872b24830f412"
    }
}