package com.erel.githubchallenge.features.repo.domain

import com.erel.githubchallenge.features.user.domain.UserUI

data class RepoUI (
    val id: Int,
    val name: String,
    val description: String,
    val homepage: String,
    val starsCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val language: String,
    val owner: UserUI
)