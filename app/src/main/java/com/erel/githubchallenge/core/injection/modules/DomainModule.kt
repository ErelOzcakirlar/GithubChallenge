package com.erel.githubchallenge.core.injection.modules

import com.erel.githubchallenge.features.repo.domain.RepoDomainModule
import com.erel.githubchallenge.features.user.domain.UserDomainModule
import dagger.Module

@Module(
    includes = [
        RepoDomainModule::class,
        UserDomainModule::class
    ]
)
class DomainModule