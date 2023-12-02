package com.example.capstoneproject.data.model

import com.example.capstoneproject.R

data class Plant(
    val image: Int,
    val name: String,
    val latinName: String
)

val dummyPlant = listOf(
    Plant(R.drawable.plant, "Jamur", "Auricularia"),
    Plant(R.drawable.plant, "Kacang", "Picurotus"),
    Plant(R.drawable.plant, "Pepaya", "Carica"),
    Plant(R.drawable.plant, "Semangka", "Citrullus")
)