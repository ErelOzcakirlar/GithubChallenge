package com.erel.githubchallenge.features.repo.presentation

import androidx.lifecycle.ViewModel
import com.erel.githubchallenge.core.injection.util.ActivityScope
import com.erel.githubchallenge.core.injection.util.FragmentScope
import com.erel.githubchallenge.core.injection.util.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class RepoPresentationModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeRepoActivity(): RepoActivity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeRepoFragment(): RepoFragment

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    abstract fun bindRepoViewModel(repoViewModel: RepoViewModel): ViewModel

}