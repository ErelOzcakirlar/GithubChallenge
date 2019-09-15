package com.erel.githubchallenge.core.injection.modules

import androidx.lifecycle.ViewModelProvider
import com.erel.githubchallenge.core.presentation.ViewModelFactory
import com.erel.githubchallenge.features.repo.presentation.RepoPresentationModule
import com.erel.githubchallenge.features.user.presentation.UserPresentationModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        RepoPresentationModule::class,
        UserPresentationModule::class
    ]
)
abstract class PresentationModule{
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}