package com.example.capstoneproject.ui.screen.camera

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.TfLiteLandmarkClassifier
import com.example.capstoneproject.data.domain.Classification
import com.example.capstoneproject.navigation.Screen
import com.example.capstoneproject.ui.screen.camera.component.CameraContent
import com.example.capstoneproject.ui.screen.camera.component.LandmarkImageAnalyzer

@Composable
fun CameraScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    activity: ComponentActivity
) {

    val context = LocalContext.current

    if (!hasCameraPermission(context)) {
        ActivityCompat.requestPermissions(
            activity, arrayOf(Manifest.permission.CAMERA), 0
        )
    }

    var classifications by remember {
        mutableStateOf(emptyList<Classification>())
    }
    val analyzer = remember {
        LandmarkImageAnalyzer(
            classifier = TfLiteLandmarkClassifier(
                context = context
            ),
            onResults = {
                classifications = it
            }
        )
    }
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
            setImageAnalysisAnalyzer(
                ContextCompat.getMainExecutor(context),
                analyzer
            )
        }
    }
    var plantTitle by remember { mutableStateOf("Unscanned ") }
    var analysisScore by remember { mutableFloatStateOf(1f) }
    var torch by remember { mutableStateOf(false) }

    classifications.forEach {
        plantTitle = it.name
        analysisScore = it.score
    }

    CameraContent(
        modifier = modifier,
        controller = controller,
        title = plantTitle,
        score = analysisScore,
        isTorchEnabled = torch,
        onTorchValueChange = { torch = it },
        navigateToResultScreen = { title, score ->
            navController.navigate(Screen.Result.resultRoute(title, score))
        },
        navigateUp = {
            navController.navigateUp()
        }
    )
}

private fun hasCameraPermission(context: Context) = ContextCompat.checkSelfPermission(
    context, Manifest.permission.CAMERA
) == PackageManager.PERMISSION_GRANTED