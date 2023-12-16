package com.example.capstoneproject.data.remote.retrofit

import com.example.capstoneproject.data.remote.response.ArticleDetailResponse
import com.example.capstoneproject.data.remote.response.ArticlesResponse
import com.example.capstoneproject.data.remote.response.PlantResponse
import com.example.capstoneproject.data.remote.response.TanamansItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("tanaman")
    suspend fun getPlants(): PlantResponse

    @GET("tanaman/{id}")
    suspend fun getDetailPlant(
        @Path("id") id: String
    ): TanamansItem

    @GET("artikel")
    suspend fun getArticles(): ArticlesResponse

    @GET("artikel/{id}")
    suspend fun getDetailArticle(
        @Path("id") id: String
    ): ArticleDetailResponse

}