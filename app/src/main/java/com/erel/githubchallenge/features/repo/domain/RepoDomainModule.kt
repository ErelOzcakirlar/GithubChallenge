package com.erel.githubchallenge.features.repo.domain

import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.data.RepoRepository
import dagger.Module
import dagger.Provides

@Module
class RepoDomainModule {

    @Provides
    fun provideGetRepoInteractor(repoRepository: RepoRepository): BaseInteractor<GetRepoInteractor.Params, RepoRaw> =
        GetRepoInteractor(repoRepository)
}