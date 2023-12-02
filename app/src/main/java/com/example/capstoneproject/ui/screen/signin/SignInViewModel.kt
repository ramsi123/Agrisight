package com.example.capstoneproject.ui.screen.signin

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AuthRepository
import com.example.capstoneproject.ui.screen.signin.component.SignInResult
import com.example.capstoneproject.ui.screen.signin.component.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    suspend fun signIn() = repository.signIn()
    suspend fun signInWithIntent(intent: Intent) = repository.signInWithIntent(intent)

    fun onSignInResult(result: SignInResult) {
        val signInResult = repository.onSignInResult(result)
        _state.update { it.copy(
            isSignInSuccessful = signInResult.data != null,
            signInError = signInResult.errorMessage
        ) }
    }

    fun resetState() {
        _state.update { repository.resetState() }
    }

}