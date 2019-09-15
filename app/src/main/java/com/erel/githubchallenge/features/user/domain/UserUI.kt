package com.erel.githubchallenge.features.user.domain

import com.erel.githubchallenge.features.repo.domain.RepoUI

data class UserUI(
    val id: String,
    val name: String,
    val profileImage: String,
    val company: String,
    val location: String,
    val email: String,
    val bio: String,
    var repos: List<RepoUI> = listOf()
)