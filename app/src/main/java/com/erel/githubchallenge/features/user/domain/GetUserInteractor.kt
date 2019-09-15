package com.erel.githubchallenge.features.user.domain

import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.domain.RepoUI
import com.erel.githubchallenge.features.user.data.UserRaw
import com.erel.githubchallenge.features.user.data.UserRepository

class GetUserInteractor(
    private val userRepository: UserRepository,
    private val userMapper: Mapper<UserRaw, UserUI>,
    private val repoMapper: Mapper<RepoRaw, RepoUI>
) :
    BaseInteractor<GetUserInteractor.Params, UserUI>() {

    override suspend fun block(params: Params): UserUI {
        val user = userMapper.map(userRepository.getUser(params.user))
        user.repos = userRepository.getReposByUser(params.user).map { repoMapper.map(it) }
        return user
    }

    data class Params(val user: String)
}