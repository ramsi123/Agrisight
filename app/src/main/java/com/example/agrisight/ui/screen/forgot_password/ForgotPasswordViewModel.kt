package com.example.agrisight.ui.screen.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agrisight.data.AgrisightRepository
import com.example.agrisight.ui.common.UiState
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(private val repository: AgrisightRepository) : ViewModel() {

    var resetPasswordState by mutableStateOf<UiState<Boolean>>(UiState.Idle)
        private set

    fun resetPassword(email: String) = viewModelScope.launch {
        resetPasswordState = UiState.Loading
        resetPasswordState = repository.resetPassword(email) ?: UiState.Success(false)
    }

}