package com.example.capstoneproject.data.remote.response

import com.google.gson.annotations.SerializedName

data class PlantResponse(

	@field:SerializedName("data")
	val articleData: PlantData? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class PlantData(

	@field:SerializedName("tanamans")
	val tanamans: List<TanamansItem?>? = null
)

data class TanamansItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("nama_latin")
	val namaLatin: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
)
