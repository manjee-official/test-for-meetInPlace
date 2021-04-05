package com.example.meetinplace.data.source.remote

import com.example.meetinplace.data.model.GeoCodeData
import com.example.meetinplace.data.model.KakaoAddressData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MapRemoteDataSource {

    @GET("geocode")
    fun searchAddress(@Query("query") query: String): Call<GeoCodeData>

    @GET("keyword.json")
    fun searchAddressWithKakao(@Query("query") query: String): Call<KakaoAddressData>
}