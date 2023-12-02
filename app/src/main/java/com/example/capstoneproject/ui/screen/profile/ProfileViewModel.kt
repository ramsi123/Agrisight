package com.example.capstoneproject.ui.screen.profile

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AuthRepository

class ProfileViewModel(private val repository: AuthRepository) : ViewModel() {

    suspend fun signOut() = repository.signOut()

}