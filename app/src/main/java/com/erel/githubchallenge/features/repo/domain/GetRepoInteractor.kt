package com.erel.githubchallenge.features.repo.domain

import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.data.RepoRepository
import javax.inject.Inject

class GetRepoInteractor(
    private val repoRepository: RepoRepository,
    private val repoMapper: Mapper<RepoRaw, RepoUI>
) :
    BaseInteractor<GetRepoInteractor.Params, RepoUI>() {

    override suspend fun block(params: Params): RepoUI =
        repoMapper.map(repoRepository.getRepo(params.user, params.repo))


    data class Params(val user: String, val repo: String)
}