package com.erel.githubchallenge.core

import android.app.Application
import com.erel.githubchallenge.core.injection.DaggerAppComponent

class GithubApp : Application(){

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }
}