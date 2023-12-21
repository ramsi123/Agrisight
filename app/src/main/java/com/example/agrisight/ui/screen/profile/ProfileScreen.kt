package com.example.agrisight.ui.screen.profile

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.agrisight.ui.ViewModelFactory
import com.example.agrisight.di.Injection
import com.example.agrisight.ui.screen.profile.component.ProfileContent
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideAgrisightRepository(LocalContext.current))
    ),
    navController: NavHostController,
    signOut: () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val user by viewModel.user.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getSignedInUser()
    }

    ProfileContent(
        modifier = modifier,
        user = user,
        signOut = {
            coroutineScope.launch {
                viewModel.signOut()
                Toast.makeText(
                    context,
                    "Signed out",
                    Toast.LENGTH_LONG
                ).show()

                signOut()
            }
        }
    )
}