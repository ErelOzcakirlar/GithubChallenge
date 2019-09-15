package com.erel.githubchallenge.features.repo.domain

import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.user.data.UserRaw
import com.erel.githubchallenge.features.user.domain.UserUI

class RepoMapper(
    private val userMapper: Mapper<UserRaw, UserUI>
) : Mapper<RepoRaw, RepoUI> {
    override fun map(raw: RepoRaw) = with(raw) {
        RepoUI(
            name.orEmpty(),
            description.orEmpty(),
            homepage.orEmpty(),
            starsCount ?: 0,
            watchersCount ?: 0,
            forksCount ?: 0,
            language.orEmpty(),
            userMapper.map(owner ?: UserRaw.default())
        )
    }
}