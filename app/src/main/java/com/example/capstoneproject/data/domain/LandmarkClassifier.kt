package com.example.capstoneproject.data.domain

import android.graphics.Bitmap

interface LandmarkClassifier {
    fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}