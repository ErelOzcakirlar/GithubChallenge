package com.erel.githubchallenge.core.injection

import com.erel.githubchallenge.core.GithubApp
import com.erel.githubchallenge.core.injection.modules.DataModule
import com.erel.githubchallenge.core.injection.modules.DomainModule
import com.erel.githubchallenge.core.injection.modules.PresentationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)

interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: GithubApp): AppComponent
    }

    fun inject(application: GithubApp)
}