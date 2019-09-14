package com.erel.githubchallenge.core.injection.modules

import com.erel.githubchallenge.features.repo.presentation.RepoPresentationModule
import dagger.Module

@Module(
    includes = [
        RepoPresentationModule::class
    ]
)
class PresentationModule