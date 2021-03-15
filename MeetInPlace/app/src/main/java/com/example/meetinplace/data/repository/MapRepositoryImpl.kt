package com.example.meetinplace.data.repository

import android.util.Log
import com.example.meetinplace.data.model.GeoCodeData
import com.example.meetinplace.data.source.remote.MapRemoteService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapRepositoryImpl : MapRepository {

    override fun searchAddressOnRemote(
        address: String,
        success: (GeoCodeData) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        Log.i("@@@@", "!!: $address")
        MapRemoteService.mapApiService.searchAddress(address).enqueue(object :
            Callback<GeoCodeData> {
            override fun onFailure(call: Call<GeoCodeData>, t: Throwable) {
                fail(t)
            }

            override fun onResponse(call: Call<GeoCodeData>, response: Response<GeoCodeData>) {
                response.body()?.copy()?.let {
                    success(it)
                }
            }
        })
    }
}
