package com.erel.githubchallenge.features.search.domain

import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.domain.RepoUI
import com.erel.githubchallenge.features.search.data.SearchRaw

class SearchMapper(
    private val repoMapper: Mapper<RepoRaw, RepoUI>
) : Mapper<SearchRaw, SearchUI> {
    override fun map(raw: SearchRaw) = with(raw) {
        SearchUI(
            totalCount ?: 0,
            items?.map { repoMapper.map(it) } ?: listOf()
        )
    }
}