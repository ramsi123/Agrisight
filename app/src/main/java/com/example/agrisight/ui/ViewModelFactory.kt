package com.example.agrisight.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.agrisight.data.AgrisightRepository
import com.example.agrisight.ui.screen.article_detail.ArticleDetailViewModel
import com.example.agrisight.ui.screen.article_list.ArticleListViewModel
import com.example.agrisight.ui.screen.forgot_password.ForgotPasswordViewModel
import com.example.agrisight.ui.screen.home.HomeViewModel
import com.example.agrisight.ui.screen.plant_detail.PlantDetailViewModel
import com.example.agrisight.ui.screen.plant_list.PlantListViewModel
import com.example.agrisight.ui.screen.profile.ProfileViewModel
import com.example.agrisight.ui.screen.result.ResultViewModel
import com.example.agrisight.ui.screen.signin.SignInViewModel
import com.example.agrisight.ui.screen.signup.SignUpViewModel
import com.example.agrisight.ui.screen.welcome.WelcomeViewModel

class ViewModelFactory(private val repository: AgrisightRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
            return WelcomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            return SignInViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(PlantListViewModel::class.java)) {
            return PlantListViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ArticleListViewModel::class.java)) {
            return ArticleListViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ArticleDetailViewModel::class.java)) {
            return ArticleDetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            return ResultViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ForgotPasswordViewModel::class.java)) {
            return ForgotPasswordViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(PlantDetailViewModel::class.java)) {
            return PlantDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}