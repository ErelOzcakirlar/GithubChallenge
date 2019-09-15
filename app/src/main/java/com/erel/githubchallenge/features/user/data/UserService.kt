package com.erel.githubchallenge.features.user.data

import com.erel.githubchallenge.features.repo.data.RepoRaw
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/{user}")
    suspend fun getUser(@Path("user") user: String): UserRaw

    @GET("users/{user}/repos")
    suspend fun getReposByUser(@Path("user") user: String): List<RepoRaw>
}