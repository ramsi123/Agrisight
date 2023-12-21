package com.example.agrisight.data.domain

import android.graphics.Bitmap

interface SoilClassifier {
    fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}