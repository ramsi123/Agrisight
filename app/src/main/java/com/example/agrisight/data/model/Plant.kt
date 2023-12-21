package com.example.agrisight.data.model

import com.example.agrisight.R

data class Plant(
    val image: Int,
    val name: String,
    val latinName: String
)

val dummyPlant = listOf(
    Plant(R.drawable.plant, "Jamur", "Auricularia"),
    Plant(R.drawable.plant, "Kacang", "Picurotus"),
    Plant(R.drawable.plant, "Pepaya", "Carica"),
    Plant(R.drawable.plant, "Semangka", "Citrullus"),
    Plant(R.drawable.plant, "Jamur2", "Auricularia2"),
    Plant(R.drawable.plant, "Kacang2", "Picurotus2"),
    Plant(R.drawable.plant, "Pepaya2", "Carica2"),
    Plant(R.drawable.plant, "Semangka2", "Citrullus2"),
    Plant(R.drawable.plant, "Jamur3", "Auricularia3"),
    Plant(R.drawable.plant, "Kacang3", "Picurotus3"),
    Plant(R.drawable.plant, "Pepaya3", "Carica3"),
    Plant(R.drawable.plant, "Semangka3", "Citrullus3")
)