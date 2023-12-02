package com.example.capstoneproject.di

import android.content.Context
import com.example.capstoneproject.data.AuthRepository
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object Injection {

    fun provideAuthRepository(context: Context): AuthRepository {
        val auth = Firebase.auth
        val oneTapClient = Identity.getSignInClient(context)
        return AuthRepository.getInstance(context, auth, oneTapClient)
    }
}