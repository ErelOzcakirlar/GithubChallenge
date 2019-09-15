package com.erel.githubchallenge.features.search.data

import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.google.gson.annotations.SerializedName

data class SearchRaw (
    @SerializedName("total_count") val totalCount: Int?,
    @SerializedName("items") val items: List<RepoRaw>?
)