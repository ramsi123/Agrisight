package com.example.agrisight.data.remote.response

import com.google.gson.annotations.SerializedName

data class PlantsResponse(

	@field:SerializedName("data")
	val articleData: PlantsData,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class PlantsData(

	@field:SerializedName("tanamans")
	val tanamans: List<PlantsItem>
)

data class PlantsItem(

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
