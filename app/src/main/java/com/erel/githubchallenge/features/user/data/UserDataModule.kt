package com.erel.githubchallenge.features.user.data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class UserDataModule {

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    @Singleton
    @Provides
    fun provideUserRepository(service: UserService): UserRepository = DefaultUserRepository(service)
}