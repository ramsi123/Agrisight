package com.example.capstoneproject.ui.screen.profile

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository

class ProfileViewModel(private val repository: AgrisightRepository) : ViewModel() {

    suspend fun signOut() = repository.signOut()

}