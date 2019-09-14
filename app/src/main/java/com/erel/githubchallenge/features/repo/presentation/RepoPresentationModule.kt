package com.erel.githubchallenge.features.repo.presentation

import com.erel.githubchallenge.core.injection.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RepoPresentationModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeRepoActivity(): RepoActivity

}