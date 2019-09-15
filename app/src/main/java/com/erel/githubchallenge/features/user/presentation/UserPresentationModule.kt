package com.erel.githubchallenge.features.user.presentation

import androidx.lifecycle.ViewModel
import com.erel.githubchallenge.core.injection.util.ActivityScope
import com.erel.githubchallenge.core.injection.util.FragmentScope
import com.erel.githubchallenge.core.injection.util.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class UserPresentationModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeUserActivity(): UserActivity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeUserFragment(): UserFragment

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

}