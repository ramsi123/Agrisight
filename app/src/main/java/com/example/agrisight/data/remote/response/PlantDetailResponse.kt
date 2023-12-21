package com.example.agrisight.data.remote.response

import com.google.gson.annotations.SerializedName

data class PlantDetailResponse(

	@field:SerializedName("data")
	val plantDetailData: PlantDetailData,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class PlantDetailData(

	@field:SerializedName("tanaman")
	val plantItemData: PlantItemData
)

data class PlantItemData(

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("nama_latin")
	val namaLatin: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("gambar")
	val gambar: String
)
