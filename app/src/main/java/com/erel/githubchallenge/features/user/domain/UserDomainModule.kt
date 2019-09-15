package com.erel.githubchallenge.features.user.domain

import com.erel.githubchallenge.core.GithubApp
import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.user.data.UserRaw
import dagger.Module
import dagger.Provides

@Module
class UserDomainModule {

    @Provides
    fun provideUserMapper(context: GithubApp): Mapper<UserRaw, UserUI> = UserMapper(context)

}