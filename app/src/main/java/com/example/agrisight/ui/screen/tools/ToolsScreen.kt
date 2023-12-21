package com.example.agrisight.ui.screen.tools

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.agrisight.ui.screen.tools.component.ToolsContent

@Composable
fun ToolsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    ToolsContent(modifier = modifier)
}