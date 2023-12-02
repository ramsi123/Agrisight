package com.example.capstoneproject.ui.screen.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.theme.colorPrimary

@Composable
fun SectionText(
    title: String,
    viewAll: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = viewAll,
            style = MaterialTheme.typography.bodyMedium.copy(color = colorPrimary),
            modifier = modifier.clickable {}
        )
    }
}