package com.erel.githubchallenge.features.search.presentation

import androidx.lifecycle.ViewModel
import com.erel.githubchallenge.core.injection.util.ActivityScope
import com.erel.githubchallenge.core.injection.util.FragmentScope
import com.erel.githubchallenge.core.injection.util.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SearchPresentationModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeSearchActivity(): SearchActivity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(SearchViewModel: SearchViewModel): ViewModel

}