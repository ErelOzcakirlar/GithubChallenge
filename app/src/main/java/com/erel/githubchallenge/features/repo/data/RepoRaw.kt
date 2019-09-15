package com.erel.githubchallenge.features.repo.data

import com.erel.githubchallenge.features.user.data.UserRaw
import com.google.gson.annotations.SerializedName

data class RepoRaw (
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("stargazers_count") val starsCount: Int?,
    @SerializedName("watchers_count") val watchersCount: Int?,
    @SerializedName("forks_count") val forksCount: Int?,
    @SerializedName("language") val language: String?,
    @SerializedName("owner") val owner: UserRaw?
)