package com.erel.githubchallenge.features.search.presentation

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.erel.githubchallenge.R
import com.erel.githubchallenge.core.presentation.BaseFragment
import com.erel.githubchallenge.features.repo.presentation.RepoActivity
import com.erel.githubchallenge.features.user.presentation.UserActivity
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment : BaseFragment<SearchViewModel>() {

    private lateinit var searchAdapter: SearchAdapter

    override val modelClass: Class<SearchViewModel>
        get() = SearchViewModel::class.java

    override val layoutRes: Int
        get() = R.layout.fragment_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        searchAdapter = SearchAdapter().apply {
            repoClickListener = { user, repo ->
                startActivity(RepoActivity.callingIntent(requireContext(), user, repo))
            }
            userClickListener = {
                startActivity(UserActivity.callingIntent(requireContext(), it))
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerSearchRepos) {
            adapter = searchAdapter
            val manager = LinearLayoutManager(requireContext())
            layoutManager = manager
            addOnScrollListener(object : PaginationScrollListener(manager) {
                override fun isLastPage() = viewModel.hasNextPage.not()
                override fun isLoading() = viewModel.isLoading
                override fun loadMoreItems() = viewModel.getNextPage()
            })
        }
    }

    override fun observeViewModel() = with(viewModel) {
        reposLiveData.observe(viewLifecycleOwner, Observer {
            searchAdapter.setData(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        (menu.findItem(R.id.searchView)?.actionView as? SearchView)?.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?) = true

                override fun onQueryTextChange(query: String): Boolean {
                    if (query.isEmpty()) {
                        viewModel.reset()
                    } else {
                        viewModel.searchRepos(query)
                    }
                    return true
                }
            })
        }
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

}