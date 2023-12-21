package com.example.agrisight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.agrisight.components.SetStatusBarColor
import com.example.agrisight.ui.theme.AgrisightTheme
import com.example.agrisight.ui.theme.colorPrimary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AgrisightTheme {
                SetStatusBarColor(color = colorPrimary)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SoilDetectorApp(activity = this)
                }
            }
        }
    }
}