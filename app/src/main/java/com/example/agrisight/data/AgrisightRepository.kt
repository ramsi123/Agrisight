package com.example.agrisight.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.example.agrisight.R
import com.example.agrisight.data.model.Article
import com.example.agrisight.data.model.Plant
import com.example.agrisight.data.model.dummyArticle
import com.example.agrisight.data.model.dummyPlant
import com.example.agrisight.data.remote.response.ArticleItem
import com.example.agrisight.data.remote.response.ArticlesItem
import com.example.agrisight.data.remote.response.PlantItemData
import com.example.agrisight.data.remote.response.PlantsItem
import com.example.agrisight.data.remote.retrofit.ApiService
import com.example.agrisight.ui.common.UiState
import com.example.agrisight.ui.screen.signin.component.SignInResult
import com.example.agrisight.ui.screen.signin.component.SignInState
import com.example.agrisight.ui.screen.signin.component.UserData
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.cancellation.CancellationException

class AgrisightRepository(
    private val context: Context,
    private val auth: FirebaseAuth,
    private val oneTapClient: SignInClient,
    private val apiService: ApiService
) {

    suspend fun getPlants(): Flow<List<PlantsItem>> {
        val response = apiService.getPlants()
        val data = response.articleData.tanamans
        return flowOf(data)
    }

    suspend fun getDetailPlant(plantId: String): Flow<PlantItemData> {
        val response = apiService.getDetailPlant(plantId)
        val data = response.plantDetailData.plantItemData
        return flowOf(data)
    }

    fun searchPlants(query: String): List<Plant> {
        return dummyPlant.filter {
            val name = it.name.contains(query, ignoreCase = true)

            if (name) {
                it.name.contains(query, ignoreCase = true)
            } else {
                it.latinName.contains(query, ignoreCase = true)
            }
        }
    }

    suspend fun getArticles(): Flow<List<ArticlesItem>> {
        val response = apiService.getArticles()
        val data = response.articlesData.artikels
        return flowOf(data)
    }

    suspend fun getDetailArticle(articleId: String): Flow<ArticleItem> {
        val response = apiService.getDetailArticle(articleId)
        val data = response.articleDetailData.articleItem
        return flowOf(data)
    }

    fun searchArticles(query: String): List<Article> {
        return dummyArticle.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }

    suspend fun signInGoogle(): IntentSender? {
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

    suspend fun signInWithIntentGoogle(intent: Intent): SignInResult {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)
        return try {
            val user = auth.signInWithCredential(googleCredentials).await().user
            SignInResult(
                data = user?.run {
                    UserData(
                        userId = uid,
                        email = displayName,
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

    fun onSignInGoogleResult(result: SignInResult): SignInResult {
        return result
    }

    fun resetGoogleAccountState(): SignInState {
        return SignInState()
    }

    fun getSignedInUser(): UserData? = auth.currentUser?.run {
        UserData(
            userId = uid,
            email = email,
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

    suspend fun signUpWithEmail(
        email: String, password: String
    ) = try {
        auth.createUserWithEmailAndPassword(email, password).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    suspend fun signInWithEmail(
        email: String, password: String
    ) = try {
        auth.signInWithEmailAndPassword(email, password).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    suspend fun resetPassword(email: String) = try {
        auth.sendPasswordResetEmail(email).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: AgrisightRepository? = null
        fun getInstance(
            context: Context,
            auth: FirebaseAuth,
            oneTapClient: SignInClient,
            apiService: ApiService
        ): AgrisightRepository =
            instance ?: synchronized(this) {
                instance ?: AgrisightRepository(context, auth, oneTapClient, apiService)
            }.also { instance = it }
    }
}