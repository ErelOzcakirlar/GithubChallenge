package com.erel.githubchallenge.features.repo.presentation

import androidx.lifecycle.MutableLiveData
import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.presentation.BaseViewModel
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.domain.GetRepoInteractor
import javax.inject.Inject

class RepoViewModel @Inject constructor(
    private val getRepoInteractor: BaseInteractor<GetRepoInteractor.Params, RepoRaw>
) : BaseViewModel() {

    val repoLiveData = MutableLiveData<RepoRaw>()

    fun getRepo(user: String, repo: String) =
        runInteractor(getRepoInteractor, GetRepoInteractor.Params(user, repo)) {
            repoLiveData.value = it
        }
}