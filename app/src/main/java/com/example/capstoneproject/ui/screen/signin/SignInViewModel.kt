package com.example.capstoneproject.ui.screen.signin

import android.content.Intent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.ui.common.UiState
import com.example.capstoneproject.ui.screen.signin.component.SignInResult
import com.example.capstoneproject.ui.screen.signin.component.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _googleAccountState = MutableStateFlow(SignInState())
    val googleAccountState = _googleAccountState.asStateFlow()

    var signInWithEmailAndPasswordResponse by mutableStateOf<UiState<Boolean>>(UiState.Idle)
        private set

    suspend fun signInGoogle() = repository.signInGoogle()
    suspend fun signInWithIntentGoogle(intent: Intent) = repository.signInWithIntentGoogle(intent)

    fun onSignInGoogleResult(result: SignInResult) {
        val signInResult = repository.onSignInGoogleResult(result)
        _googleAccountState.update { it.copy(
            isSignInSuccessful = signInResult.data != null,
            signInError = signInResult.errorMessage
        ) }
    }

    fun resetGoogleAccountState() {
        _googleAccountState.update { repository.resetGoogleAccountState() }
    }

    fun signInWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        signInWithEmailAndPasswordResponse = UiState.Loading
        signInWithEmailAndPasswordResponse =
            repository.firebaseSignInWithEmailAndPassword(email, password) ?: UiState.Success(false)
    }

}