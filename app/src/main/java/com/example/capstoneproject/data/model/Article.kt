package com.example.capstoneproject.data.model

import com.example.capstoneproject.R

data class Article(
    val image: Int,
    val title: String,
    val time: String,
    val category: String
)

val dummyArticle = listOf(
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team", time = "2021-05-15 07:01:20", category = "Teknologi")
)