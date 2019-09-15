package com.erel.githubchallenge.features.search.domain

import com.erel.githubchallenge.features.repo.domain.RepoUI

data class SearchUI (
    val totalCount: Int,
    val items: List<RepoUI>
)