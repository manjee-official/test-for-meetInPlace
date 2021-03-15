package com.example.meetinplace.data.repository

import com.example.meetinplace.data.model.GeoCodeData

interface MapRepository {
    fun searchAddressOnRemote(
        address: String,
        success: (GeoCodeData) -> Unit,
        fail: (Throwable) -> Unit
    )
}