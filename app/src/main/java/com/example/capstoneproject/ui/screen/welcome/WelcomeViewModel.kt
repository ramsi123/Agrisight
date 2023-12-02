package com.example.capstoneproject.ui.screen.welcome

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AuthRepository

class WelcomeViewModel(private val repository: AuthRepository) : ViewModel() {

    fun getSignedInUser() = repository.getSignedInUser()

}