package com.example.capstoneproject.di

import android.content.Context
import com.example.capstoneproject.data.AgrisightRepository
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object Injection {

    fun provideAgrisightRepository(context: Context): AgrisightRepository {
        val auth = Firebase.auth
        val oneTapClient = Identity.getSignInClient(context)
        return AgrisightRepository.getInstance(context, auth, oneTapClient)
    }
}