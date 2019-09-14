package com.erel.githubchallenge.features.repo.domain

import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.data.RepoRepository

class GetRepoInteractor(private val repoRepository: RepoRepository) :
    BaseInteractor<GetRepoInteractor.Params, RepoRaw>() {

    override suspend fun block(params: Params): RepoRaw =
        repoRepository.getRepo(params.user, params.repo)


    data class Params(val user: String, val repo: String)
}