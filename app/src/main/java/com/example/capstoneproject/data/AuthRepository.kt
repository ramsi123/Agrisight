package com.example.capstoneproject.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.common.UiState
import com.example.capstoneproject.ui.screen.signin.component.SignInResult
import com.example.capstoneproject.ui.screen.signin.component.SignInState
import com.example.capstoneproject.ui.screen.signin.component.UserData
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.cancellation.CancellationException

class AuthRepository(
    private val context: Context,
    private val auth: FirebaseAuth,
    private val oneTapClient: SignInClient
) {

    suspend fun signIn(): IntentSender? {
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            null
        }

        return result?.pendingIntent?.intentSender
    }

    suspend fun signInWithIntent(intent: Intent): SignInResult {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)
        return try {
            val user = auth.signInWithCredential(googleCredentials).await().user
            SignInResult(
                data = user?.run {
                    UserData(
                        userId = uid,
                        username = displayName,
                        profilePictureUrl = photoUrl?.toString()
                    )
                },
                errorMessage = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            SignInResult(
                data = null,
                errorMessage = e.message
            )
        }
    }

    suspend fun signOut() {
        try {
            oneTapClient.signOut().await()
            auth.signOut()
        } catch (e:Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
        }
    }

    fun onSignInResult(result: SignInResult): SignInResult {
        return result
    }

    fun resetState(): SignInState {
        return SignInState()
    }

    fun getSignedInUser(): UserData? = auth.currentUser?.run {
        UserData(
            userId = uid,
            username = displayName,
            profilePictureUrl = photoUrl?.toString()
        )
    }

    private fun buildSignInRequest(): BeginSignInRequest {
        return BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.Builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(context.getString(R.string.web_client_id))
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
    }

    val currentUser get() = auth.currentUser

    suspend fun firebaseSignUpWithEmailAndPassword(
        email: String, password: String
    ) = try {
        auth.createUserWithEmailAndPassword(email, password).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    suspend fun sendEmailVerification() = try {
        auth.currentUser?.sendEmailVerification()?.await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    suspend fun firebaseSignInWithEmailAndPassword(
        email: String, password: String
    ) = try {
        auth.signInWithEmailAndPassword(email, password).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    suspend fun reloadFirebaseUser() = try {
        auth.currentUser?.reload()?.await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    suspend fun sendPasswordResetEmail(email: String) = try {
        auth.sendPasswordResetEmail(email).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    fun signOut2() = auth.signOut()

    suspend fun revokeAccess() = try {
        auth.currentUser?.delete()?.await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    fun getAuthState(viewModelScope: CoroutineScope) = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), auth.currentUser == null)

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: AuthRepository? = null
        fun getInstance(
            context: Context,
            auth: FirebaseAuth,
            oneTapClient: SignInClient
        ): AuthRepository =
            instance ?: synchronized(this) {
                instance ?: AuthRepository(context, auth, oneTapClient)
            }.also { instance = it }
    }
}