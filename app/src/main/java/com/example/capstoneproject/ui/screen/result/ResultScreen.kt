package com.example.capstoneproject.ui.screen.result

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.capstoneproject.ui.screen.result.component.ResultContent

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    title: String,
    score: Float
) {
    ResultContent(title = title, score = score)
}