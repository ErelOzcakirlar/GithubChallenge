package com.erel.githubchallenge.features.user.domain

data class UserUI(
    val id: String,
    val name: String,
    val profileImage: String,
    val company: String,
    val location: String,
    val email: String,
    val bio: String
)