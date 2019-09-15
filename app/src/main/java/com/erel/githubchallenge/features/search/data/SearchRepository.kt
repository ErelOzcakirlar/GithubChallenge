package com.erel.githubchallenge.features.search.data

interface SearchRepository {
    suspend fun getSearch(q: String, perPage: Int, page: Int): SearchRaw
}

class DefaultSearchRepository(private val searchService: SearchService) : SearchRepository {
    override suspend fun getSearch(q: String, perPage: Int, page: Int): SearchRaw =
        searchService.getSearch(q, perPage, page)
}