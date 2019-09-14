package com.erel.githubchallenge.features.repo.presentation

import com.erel.githubchallenge.core.presentation.BaseActivity

class RepoActivity : BaseActivity() {

    override fun getFragmentInstance() =
        RepoFragment.newInstance("ErelOzcakirlar", "MovieDBChallenge")
}