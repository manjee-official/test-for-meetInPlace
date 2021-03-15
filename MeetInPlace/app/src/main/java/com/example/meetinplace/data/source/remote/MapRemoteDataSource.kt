package com.example.meetinplace.data.source.remote

import com.example.meetinplace.data.model.GeoCodeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MapRemoteDataSource {

    @GET("geocode.json")
    fun searchAddress(@Query("query") query: String): Call<GeoCodeData>
}