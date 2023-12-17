package com.example.capstoneproject.ui.screen.plant_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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

@Composable
fun PlantListItem(
    modifier: Modifier = Modifier,
    plant: PlantsItem,
    onClick: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick(plant.id)
            }
            .padding(12.dp),
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
                fontSize = 14.sp
            )
            Text(
                text = plant.namaLatin,
                color = lightGray,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
fun PlantListItemPreview() {
    PlantListItem(
        plant = PlantsItem(
            nama = "Jamur",
            namaLatin = "Pleuretus",
            id = "1",
            deskripsi = "",
            gambar = ""
        ),
        onClick = {}
    )
}