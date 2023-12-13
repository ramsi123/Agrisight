package com.example.capstoneproject.ui.screen.profile

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.ui.screen.signin.component.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _user: MutableStateFlow<UserData> = MutableStateFlow(UserData(userId = "", username = "", profilePictureUrl = ""))
    val user = _user.asStateFlow()

    suspend fun signOut() = repository.signOut()

    fun getSignedInUser() {
        _user.value = repository.getSignedInUser() ?: UserData(userId = "", username = "", profilePictureUrl = "")
    }

}