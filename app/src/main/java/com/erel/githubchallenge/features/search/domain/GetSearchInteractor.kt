package com.erel.githubchallenge.features.search.domain

import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.search.data.SearchRaw
import com.erel.githubchallenge.features.search.data.SearchRepository

class GetSearchInteractor(
    private val searchRepository: SearchRepository,
    private val searchMapper: Mapper<SearchRaw, SearchUI>
) :
    BaseInteractor<GetSearchInteractor.Params, SearchUI>() {

    override suspend fun block(params: Params): SearchUI =
        searchMapper.map(searchRepository.getSearch(params.q, params.perPage, params.page))

    data class Params(val q: String, val perPage: Int, val page: Int)
}