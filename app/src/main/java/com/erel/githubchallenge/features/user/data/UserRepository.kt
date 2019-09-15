package com.erel.githubchallenge.features.user.data

import com.erel.githubchallenge.features.repo.data.RepoRaw

interface UserRepository {
    suspend fun getUser(user: String): UserRaw
    suspend fun getReposByUser(user: String): List<RepoRaw>
}

class DefaultUserRepository(private val userService: UserService) : UserRepository {

    override suspend fun getUser(user: String): UserRaw =
        userService.getUser(user)

    override suspend fun getReposByUser(user: String): List<RepoRaw> =
        userService.getReposByUser(user)
}