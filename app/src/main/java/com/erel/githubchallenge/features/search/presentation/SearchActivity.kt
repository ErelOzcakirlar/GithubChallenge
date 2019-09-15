package com.erel.githubchallenge.features.search.presentation

import com.erel.githubchallenge.core.presentation.BaseActivity

class SearchActivity : BaseActivity() {
    override fun getFragmentInstance() = SearchFragment.newInstance()
}