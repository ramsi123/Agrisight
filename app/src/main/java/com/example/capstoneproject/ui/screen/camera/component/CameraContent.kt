package com.example.capstoneproject.ui.screen.camera.component

import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.sharp.Lens
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.theme.darkGray
import com.example.capstoneproject.util.Constants.CAMERA_LABEL
import com.example.capstoneproject.util.Constants.TITLE

@Composable
fun CameraContent(
    modifier: Modifier = Modifier,
    controller: LifecycleCameraController,
    title: String,
    score: Float,
    isTorchEnabled: Boolean,
    onTorchValueChange: (Boolean) -> Unit,
    navigateToResultScreen: (String, Float) -> Unit,
    navigateUp: () -> Unit
) {
    val flashIcon = if (isTorchEnabled) {
        Icons.Default.FlashOn
    } else {
        Icons.Default.FlashOff
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        CameraPreview(controller = controller, modifier = modifier.fillMaxSize())
        IconButton(
            modifier = modifier.padding(start = 6.dp, top = 6.dp),
            onClick = {
                navigateUp()
            },
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            )
        ) {
            Icon(
                modifier = modifier
                    .size(50.dp)
                    .padding(6.dp),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
        }
        Text(
            modifier = modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp),
            text = TITLE,
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.josefin_sans_semibold_italic)),
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )
        IconButton(
            modifier = modifier
                .align(Alignment.TopEnd)
                .padding(start = 6.dp, top = 6.dp),
            onClick = {
                if (isTorchEnabled) {
                    controller.enableTorch(false)
                    onTorchValueChange(false)
                } else {
                    controller.enableTorch(true)
                    onTorchValueChange(true)
                }
            },
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            )
        ) {
            Icon(
                modifier = modifier
                    .size(50.dp)
                    .padding(6.dp),
                imageVector = flashIcon,
                contentDescription = null
            )
        }
        Column(
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = darkGray)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$title with $score accuracy",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                    ),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = modifier.height(5.dp))
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = darkGray)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = CAMERA_LABEL,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                    )
                )
            }
            Spacer(modifier = modifier.height(5.dp))
            IconButton(
                onClick = {
                    navigateToResultScreen(title, score)
                },
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = darkGray,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    modifier = modifier
                        .size(100.dp)
                        .padding(1.dp)
                        .border(1.dp, Color.White, CircleShape),
                    imageVector = Icons.Sharp.Lens,
                    contentDescription = "Take picture",
                    tint = Color.White
                )
            }
        }
    }
}