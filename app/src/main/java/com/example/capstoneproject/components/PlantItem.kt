package com.example.capstoneproject.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.capstoneproject.R
import com.example.capstoneproject.data.remote.response.PlantsItem
import com.example.capstoneproject.ui.theme.lightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantItem(
    modifier: Modifier = Modifier,
    plant: PlantsItem,
    onClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        onClick = {
            onClick(plant.id)
        }
    ) {
        Row(
            modifier = modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape),
                model = plant.gambar,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = plant.nama,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 14.sp,
                    lineHeight = 16.sp
                )
                Text(
                    text = plant.namaLatin,
                    color = lightGray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlantItemPreview() {
    PlantItem(
        plant = PlantsItem(nama = "", namaLatin = "", id = "", deskripsi = "", gambar = ""),
        onClick = {}
    )
}