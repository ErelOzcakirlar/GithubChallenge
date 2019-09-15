package com.erel.githubchallenge.features.search.data

import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("search/repositories")
    suspend fun getSearch(
        @Query("q") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): SearchRaw
}