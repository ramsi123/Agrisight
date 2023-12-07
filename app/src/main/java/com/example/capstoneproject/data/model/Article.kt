package com.example.capstoneproject.data.model

import com.example.capstoneproject.R

data class Article(
    val image: Int,
    val title: String,
    val time: String,
    val category: String
)

val dummyArticle = listOf(
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team1", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team2", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team3", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team4", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team5", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team6", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team7", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team8", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team9", time = "2021-05-15 07:01:20", category = "Teknologi"),
    Article(image = R.drawable.garden, title = "Mewujudkan Digital Farming Bersama Soil Detector Team10", time = "2021-05-15 07:01:20", category = "Teknologi")
)