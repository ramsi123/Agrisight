package com.example.capstoneproject.ui.screen.welcome

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository

class WelcomeViewModel(private val repository: AgrisightRepository) : ViewModel() {

    fun getSignedInUser() = repository.getSignedInUser()

}