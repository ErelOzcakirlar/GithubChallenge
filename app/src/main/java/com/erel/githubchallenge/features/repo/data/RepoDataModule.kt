package com.erel.githubchallenge.features.repo.data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepoDataModule {

    @Singleton
    @Provides
    fun provideRepoService(retrofit: Retrofit): RepoService =
        retrofit.create(RepoService::class.java)

    @Singleton
    @Provides
    fun provideRepoRepository(service: RepoService): RepoRepository = DefaultRepoRepository(service)
}