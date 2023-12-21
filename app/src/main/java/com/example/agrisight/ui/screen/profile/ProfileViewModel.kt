package com.example.agrisight.ui.screen.profile

import androidx.lifecycle.ViewModel
import com.example.agrisight.data.AgrisightRepository
import com.example.agrisight.ui.screen.signin.component.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(private val repository: AgrisightRepository) : ViewModel() {

    private val _user: MutableStateFlow<UserData> = MutableStateFlow(UserData(userId = "", email = "", profilePictureUrl = ""))
    val user = _user.asStateFlow()

    suspend fun signOut() = repository.signOut()

    fun getSignedInUser() {
        _user.value = repository.getSignedInUser() ?: UserData(userId = "", email = "", profilePictureUrl = "")
    }

}