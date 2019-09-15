package com.erel.githubchallenge.features.repo.domain

import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.data.RepoRepository
import com.erel.githubchallenge.features.user.data.UserRaw
import com.erel.githubchallenge.features.user.domain.UserUI
import dagger.Module
import dagger.Provides

@Module
class RepoDomainModule {

    @Provides
    fun provideGetRepoInteractor(
        repoRepository: RepoRepository,
        repoMapper: Mapper<RepoRaw, RepoUI>
    ): BaseInteractor<GetRepoInteractor.Params, RepoUI> =
        GetRepoInteractor(repoRepository, repoMapper)

    @Provides
    fun provideRepoMapper(userMapper: Mapper<UserRaw, UserUI>): Mapper<RepoRaw, RepoUI> =
        RepoMapper(userMapper)
}