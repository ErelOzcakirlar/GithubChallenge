package com.erel.githubchallenge.features.user.presentation

import com.erel.githubchallenge.core.presentation.BaseActivity

class UserActivity: BaseActivity() {

    override fun getFragmentInstance() =
        UserFragment.newInstance("ErelOzcakirlar")

}