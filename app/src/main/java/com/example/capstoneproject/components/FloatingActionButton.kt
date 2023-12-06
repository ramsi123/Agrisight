package com.example.capstoneproject.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import com.example.capstoneproject.ui.theme.colorPrimary
import com.example.capstoneproject.ui.theme.ghostWhite

@Composable
fun FloatingActionButton(onCameraClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onCameraClick() },
        containerColor = colorPrimary,
        contentColor = ghostWhite
    ) {
        Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = null)
    }
}