package com.example.meetinplace.data.model

data class GeoCodeData(
    val status: String,
    val errorMessage: String,
    val meta: GeoMeta,
    val address: GeoAddress?
)

data class GeoMeta(
    val totalCount: Int,
    val page: Int,
    val count: Int
)

data class GeoAddress(
    val readAddress: String,
    val jibunAddress: String,
    val englishAddress: String,
    val x: String,
    val y: String,
    val distance: Double,
    val addressElements: List<GeoAddressElements>
)

data class GeoAddressElements(
    val type: List<String>,
    val longName: String,
    val shortName: String,
    val code: String
)

