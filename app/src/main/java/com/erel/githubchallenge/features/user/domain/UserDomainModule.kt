package com.erel.githubchallenge.features.user.domain

import com.erel.githubchallenge.core.GithubApp
import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.domain.RepoUI
import com.erel.githubchallenge.features.user.data.UserRaw
import com.erel.githubchallenge.features.user.data.UserRepository
import dagger.Module
import dagger.Provides

@Module
class UserDomainModule {

    @Provides
    fun provideGetUserInteractor(
        userRepository: UserRepository,
        userMapper: Mapper<UserRaw, UserUI>,
        repoMapper: Mapper<RepoRaw, RepoUI>
    ): BaseInteractor<GetUserInteractor.Params, UserUI> =
        GetUserInteractor(userRepository, userMapper, repoMapper)

    @Provides
    fun provideUserMapper(context: GithubApp): Mapper<UserRaw, UserUI> = UserMapper(context)

}