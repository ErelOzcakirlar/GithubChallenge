package com.erel.githubchallenge.core.injection.modules

import com.erel.githubchallenge.features.repo.domain.RepoDomainModule
import dagger.Module

@Module(
    includes = [
        RepoDomainModule::class
    ]
)
class DomainModule