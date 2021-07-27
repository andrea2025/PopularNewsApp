package com.example.newsapp.data.model

import com.example.newsapp.ui.newslist.NewsList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("viewed/{7}.json?api-key=dLYSJVjcuZ4TmfS7KnogQzm2yHGCwrHZ")
    suspend fun getViewed(): Response<List<NewsList>>
}