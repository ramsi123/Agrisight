package com.example.capstoneproject.ui.screen.plant_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.theme.lightGray

@Composable
fun PlantListItem(
    modifier: Modifier = Modifier,
    image: Int,
    name: String,
    latinName: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {}
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier.size(40.dp),
            painter = painterResource(image),
            contentDescription = null
        )
        Column {
            Text(
                text = name,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                fontSize = 14.sp
            )
            Text(
                text = latinName,
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
    PlantListItem(image = R.drawable.plant, name = "Jamur", latinName = "Pleuretus")
}