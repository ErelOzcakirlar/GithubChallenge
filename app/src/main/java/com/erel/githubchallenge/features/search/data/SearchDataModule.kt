package com.erel.githubchallenge.features.search.data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class SearchDataModule {

    @Singleton
    @Provides
    fun provideSearchService(retrofit: Retrofit): SearchService =
        retrofit.create(SearchService::class.java)

    @Singleton
    @Provides
    fun provideSearchRepository(service: SearchService): SearchRepository =
        DefaultSearchRepository(service)
}