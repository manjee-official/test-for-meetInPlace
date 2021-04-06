package com.example.meetinplace.data.repository

import com.example.meetinplace.data.model.Document
import com.example.meetinplace.data.model.GeoCodeData
import com.example.meetinplace.data.model.KakaoAddressData

interface MapRepository {
    fun searchAddressOnRemote(
        address: String,
        success: (GeoCodeData) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun searchAddressOnRemoteWithKakao(
            keyword: String,
            success: (Document) -> Unit,
            fail: (Throwable) -> Unit
    )
}