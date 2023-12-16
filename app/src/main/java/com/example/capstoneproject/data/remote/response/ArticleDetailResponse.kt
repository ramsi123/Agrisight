package com.example.capstoneproject.data.remote.response

import com.google.gson.annotations.SerializedName

data class ArticleDetailResponse(

	@field:SerializedName("data")
	val articleDetailData: ArticleDetailData,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class ArticleDetailData(

	@field:SerializedName("artikel")
	val articleItem: ArticleItem
)

data class ArticleItem(

	@field:SerializedName("kategori")
	val kategori: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("deskripsi")
	val deskripsi: String,

	@field:SerializedName("tanggal")
	val tanggal: String,

	@field:SerializedName("judul")
	val judul: String,

	@field:SerializedName("gambar")
	val gambar: String
)
