package com.erel.githubchallenge.features.repo.data

import retrofit2.http.GET
import retrofit2.http.Path

interface RepoService {
    @GET("repos/{user}/{repo}")
    suspend fun getRepo(@Path("user") user: String, @Path("repo") repo: String): RepoRaw
}