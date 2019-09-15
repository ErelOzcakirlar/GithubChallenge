package com.erel.githubchallenge.features.user.domain

import com.erel.githubchallenge.R
import com.erel.githubchallenge.core.GithubApp
import com.erel.githubchallenge.core.domain.Mapper
import com.erel.githubchallenge.features.user.data.UserRaw

class UserMapper(
    private val context: GithubApp
) : Mapper<UserRaw, UserUI> {
    override fun map(raw: UserRaw) = with(raw) {
        val newName = if (name.isNullOrEmpty()) {
            context.resources.getString(R.string.user_default_name)
        } else {
            name
        }
        UserUI(
            id.orEmpty(),
            newName,
            profileImage.orEmpty(),
            company.orEmpty(),
            location.orEmpty(),
            email.orEmpty(),
            bio.orEmpty()
        )
    }
}