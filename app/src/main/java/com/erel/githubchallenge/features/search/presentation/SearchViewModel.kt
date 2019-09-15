package com.erel.githubchallenge.features.search.presentation

import androidx.lifecycle.MutableLiveData
import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.extensions.EMPTY
import com.erel.githubchallenge.core.presentation.BaseViewModel
import com.erel.githubchallenge.features.repo.domain.RepoUI
import com.erel.githubchallenge.features.search.domain.GetSearchInteractor
import com.erel.githubchallenge.features.search.domain.SearchUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getSearchInteractor: BaseInteractor<GetSearchInteractor.Params, SearchUI>
) : BaseViewModel() {

    private var waitingQuery = EMPTY
    private var totalItems = INITIAL_COUNT
    private var page = INITIAL_PAGE

    val reposLiveData = MutableLiveData<List<RepoUI>>()

    val hasNextPage: Boolean
        get() = reposLiveData.value?.size ?: INITIAL_COUNT < totalItems

    var isLoading: Boolean = false
        private set

    fun searchRepos(query: String) {
        waitingQuery = query
        GlobalScope.launch(Dispatchers.IO) {
            delay(DEBOUNCE_PERIOD_IN_MILLIS)
            if (query == waitingQuery) {
                page = INITIAL_PAGE
                isLoading = true
                runInteractor(
                    getSearchInteractor,
                    GetSearchInteractor.Params(waitingQuery, PER_PAGE, INITIAL_PAGE),
                    false,
                    {
                        isLoading = false
                    }
                ) {
                    isLoading = false
                    totalItems = it?.totalCount ?: INITIAL_COUNT
                    reposLiveData.value = it?.items
                }
            }
        }
    }

    fun getNextPage() {
        isLoading = true
        runInteractor(
            getSearchInteractor,
            GetSearchInteractor.Params(waitingQuery, PER_PAGE, ++page),
            false,
            {
                isLoading = false
            }
        ) {
            isLoading = false
            totalItems = it?.totalCount ?: INITIAL_COUNT
            val newValue = ArrayList<RepoUI>()
            newValue.addAll(reposLiveData.value ?: listOf())
            newValue.addAll(it?.items ?: listOf())
            reposLiveData.value = newValue
        }
    }

    fun reset() {
        waitingQuery = EMPTY
        totalItems = INITIAL_COUNT
        page = INITIAL_PAGE
        reposLiveData.value = listOf()
    }

    companion object {
        private const val INITIAL_COUNT = 0
        private const val INITIAL_PAGE = 1
        private const val PER_PAGE = 20
        private const val DEBOUNCE_PERIOD_IN_MILLIS = 1000L
    }

}