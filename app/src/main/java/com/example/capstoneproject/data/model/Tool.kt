package com.example.capstoneproject.data.model

import com.example.capstoneproject.R

data class Tool(
    val image: Int,
    val name: String
)

val dummyTool = listOf(
    Tool(image = R.drawable.farming_tool, name = "Deteksi Hama/Penyakit"),
    Tool(image = R.drawable.farming_tool, name = "Kebutuhan Pupuk"),
    Tool(image = R.drawable.farming_tool, name = "Populasi Tanaman"),
    Tool(image = R.drawable.farming_tool, name = "Produktifitas Tanaman"),
    Tool(image = R.drawable.farming_tool, name = "Kebutuhan Air")
)