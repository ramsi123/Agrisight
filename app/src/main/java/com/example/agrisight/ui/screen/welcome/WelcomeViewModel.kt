package com.example.agrisight.ui.screen.welcome

import androidx.lifecycle.ViewModel
import com.example.agrisight.data.AgrisightRepository

class WelcomeViewModel(private val repository: AgrisightRepository) : ViewModel() {

    fun getSignedInUser() = repository.getSignedInUser()

}