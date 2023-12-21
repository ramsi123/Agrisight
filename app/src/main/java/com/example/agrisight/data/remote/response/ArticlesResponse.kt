package com.example.agrisight.data.remote.response

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(

	@field:SerializedName("data")
	val articlesData: ArticlesData,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class ArticlesItem(

	@field:SerializedName("kategori")
	val kategori: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("tanggal")
	val tanggal: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("judul")
	val judul: String,

	@field:SerializedName("gambar")
	val gambar: String
)

data class ArticlesData(

	@field:SerializedName("artikels")
	val artikels: List<ArticlesItem>
)
