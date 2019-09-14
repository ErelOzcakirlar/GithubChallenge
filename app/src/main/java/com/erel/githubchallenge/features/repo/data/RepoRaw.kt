package com.erel.githubchallenge.features.repo.data

import com.google.gson.annotations.SerializedName

data class RepoRaw (
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("private") val isPrivate: Boolean,
    @SerializedName("has_issues") val hasIssues: Boolean,
    @SerializedName("has_projects") val hasProjects: Boolean,
    @SerializedName("has_wiki") val hasWiki: Boolean
)