package com.example.capstoneproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.capstoneproject.data.AgrisightRepository
import com.example.capstoneproject.ui.screen.article_detail.ArticleDetailViewModel
import com.example.capstoneproject.ui.screen.article_list.ArticleListViewModel
import com.example.capstoneproject.ui.screen.home.HomeViewModel
import com.example.capstoneproject.ui.screen.plant_list.PlantListViewModel
import com.example.capstoneproject.ui.screen.profile.ProfileViewModel
import com.example.capstoneproject.ui.screen.result.ResultViewModel
import com.example.capstoneproject.ui.screen.signin.SignInViewModel
import com.example.capstoneproject.ui.screen.signup.SignUpViewModel
import com.example.capstoneproject.ui.screen.welcome.WelcomeViewModel

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
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}