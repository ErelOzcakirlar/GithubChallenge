package com.erel.githubchallenge.core.injection.modules

import com.erel.githubchallenge.features.repo.domain.RepoDomainModule
import com.erel.githubchallenge.features.search.domain.SearchDomainModule
import com.erel.githubchallenge.features.user.domain.UserDomainModule
import dagger.Module

@Module(
    includes = [
        RepoDomainModule::class,
        UserDomainModule::class,
        SearchDomainModule::class
    ]
)
class DomainModule