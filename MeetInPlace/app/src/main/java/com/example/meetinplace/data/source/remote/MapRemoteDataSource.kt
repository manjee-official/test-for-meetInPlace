package com.example.meetinplace.data.source.remote

import com.example.meetinplace.data.model.Document
import com.example.meetinplace.data.model.GeoCodeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MapRemoteDataSource {

    @GET("geocode")
    fun searchAddress(@Query("query") query: String): Call<GeoCodeData>

    @GET("keyword.json")
    @Headers("Content-Type: application/json;charset=UTF-8")
    fun searchAddressWithKakao(@Query("query") query: String): Call<Document>
}