package com.erel.githubchallenge.features.search.domain

import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.domain.RepoUI
import com.erel.githubchallenge.features.search.data.SearchRaw
import com.erel.githubchallenge.features.search.data.SearchRepository
import dagger.Module
import dagger.Provides

@Module
class SearchDomainModule {

    @Provides
    fun provideGetSearchInteractor(
        searchRepository: SearchRepository,
        searchMapper: Mapper<SearchRaw, SearchUI>
    ): BaseInteractor<GetSearchInteractor.Params, SearchUI> =
        GetSearchInteractor(searchRepository, searchMapper)

    @Provides
    fun provideSearchMapper(repoMapper: Mapper<RepoRaw, RepoUI>): Mapper<SearchRaw, SearchUI> =
        SearchMapper(repoMapper)

}