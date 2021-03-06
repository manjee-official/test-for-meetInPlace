package com.example.meetinplace.data.model

data class Document(
		val documents: List<KakaoAddressData>
)

data class KakaoAddressData(
		val address_name: String?,
		val category_group_code: String?,
		val category_group_name: String?,
		val category_name: String?,
		val distance: String?,
		val id: String?,
		val phone: String?,
		val place_name: String?,
		val place_url: String?,
		val road_address_name: String?,
		val x: String?,
		val y: String?
)