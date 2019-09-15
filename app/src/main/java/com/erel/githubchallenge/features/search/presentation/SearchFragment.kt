package com.erel.githubchallenge.features.search.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.erel.githubchallenge.R
import com.erel.githubchallenge.core.presentation.BaseFragment

class SearchFragment : BaseFragment<SearchViewModel>() {

    override val modelClass: Class<SearchViewModel>
        get() = SearchViewModel::class.java

    override val layoutRes: Int
        get() = R.layout.fragment_repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel.searchRepos("retrofit")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun observeViewModel() = with(viewModel) {
        reposLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("Repos", "count:${it.size}")
        })
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

}