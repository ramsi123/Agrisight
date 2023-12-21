package com.example.agrisight.di

import android.content.Context
import com.example.agrisight.data.AgrisightRepository
import com.example.agrisight.data.remote.retrofit.ApiConfig
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object Injection {
    fun provideAgrisightRepository(context: Context): AgrisightRepository {
        val auth = Firebase.auth
        val oneTapClient = Identity.getSignInClient(context)
        val apiService = ApiConfig.getApiService()
        return AgrisightRepository.getInstance(context, auth, oneTapClient, apiService)
    }
}