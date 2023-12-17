package com.example.capstoneproject.ui.screen.result.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.components.TopBar
import com.example.capstoneproject.components.PlantItem
import com.example.capstoneproject.data.remote.response.PlantsItem
import com.example.capstoneproject.ui.theme.lightGray
import com.example.capstoneproject.util.Constants
import com.example.capstoneproject.util.Constants.PLANT_RECOMMENDATION
import com.example.capstoneproject.util.Constants.RESULT_SCREEN
import com.example.capstoneproject.util.Constants.SOIL_RESULT

@Composable
fun ResultContent(
    modifier: Modifier = Modifier,
    title: String,
    score: Double,
    plants: List<PlantsItem>,
    navigateBack: () -> Unit,
    navigateToPlantDetailScreen: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(title = RESULT_SCREEN, navigateBack = navigateBack)
        }
    ) { innerPadding ->
        Box(
            modifier = modifier.padding(innerPadding)
        ) {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                contentPadding = PaddingValues(start = 20.dp, top = 20.dp, end = 20.dp)
            ) {
                item {
                    Text(
                        modifier = modifier.padding(bottom = 12.dp),
                        text = SOIL_RESULT,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                        )
                    )
                }
                item {
                    Card(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    modifier = modifier.size(100.dp),
                                    painter = painterResource(R.drawable.soil_analysis),
                                    contentDescription = Constants.GREEN_HOUSE
                                )
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.End
                                ) {
                                    Text(
                                        text = title,
                                        color = Color.Black,
                                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                                        textAlign = TextAlign.End,
                                        fontSize = 16.sp,
                                        lineHeight = 20.sp
                                    )
                                    Text(
                                        modifier = modifier.padding(top = 6.dp, bottom = 12.dp),
                                        text = "with $score% accuracy",
                                        color = lightGray,
                                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                                        textAlign = TextAlign.End,
                                        fontSize = 12.sp,
                                        lineHeight = 18.sp
                                    )
                                }
                            }
                        }
                    }
                }
                item {
                    Text(
                        modifier = modifier.padding(bottom = 12.dp),
                        text = PLANT_RECOMMENDATION,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                        )
                    )
                }
                items(plants) { plant ->
                    PlantItem(
                        plant = plant,
                        onClick = navigateToPlantDetailScreen
                    )
                }
            }
        }
    }
}