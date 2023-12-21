package com.example.agrisight.data.remote.retrofit

import com.example.agrisight.data.remote.response.ArticleDetailResponse
import com.example.agrisight.data.remote.response.ArticlesResponse
import com.example.agrisight.data.remote.response.PlantDetailResponse
import com.example.agrisight.data.remote.response.PlantsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("tanaman")
    suspend fun getPlants(): PlantsResponse

    @GET("tanaman/{id}")
    suspend fun getDetailPlant(
        @Path("id") id: String
    ): PlantDetailResponse

    @GET("artikel")
    suspend fun getArticles(): ArticlesResponse

    @GET("artikel/{id}")
    suspend fun getDetailArticle(
        @Path("id") id: String
    ): ArticleDetailResponse

}