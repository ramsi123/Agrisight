package com.example.agrisight.ui.screen.signin.component

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val email: String?,
    val profilePictureUrl: String?
)
