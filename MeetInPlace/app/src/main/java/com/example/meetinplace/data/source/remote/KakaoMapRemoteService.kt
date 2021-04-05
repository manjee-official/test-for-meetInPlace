package com.example.meetinplace.data.source.remote

import com.example.meetinplace.MyApplication
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object KakaoMapRemoteService {
    private const val kakaoMapApiUrl =
        "https://dapi.kakao.com/v2/local/search/"
    private const val readWriteTimeoutSec = 20L

    val mapApiService: MapRemoteDataSource
        get() = mapRetrofit.create(MapRemoteDataSource::class.java)

    private val mHttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val mOkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(readWriteTimeoutSec, TimeUnit.SECONDS)
        .writeTimeout(readWriteTimeoutSec, TimeUnit.SECONDS)
        .addInterceptor(mHttpLoggingInterceptor)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Authorization", MyApplication.KAKAO_API_KEY).build()
            chain.proceed(request)
        }

    private val mapRetrofit: Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(kakaoMapApiUrl)
            .client(mOkHttpClient.build())
            .build()
}