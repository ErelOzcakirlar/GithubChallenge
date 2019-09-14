package com.erel.githubchallenge.features.repo.presentation

import android.os.Bundle
import android.util.Log
import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.domain.DataHolderType
import com.erel.githubchallenge.core.presentation.BaseActivity
import com.erel.githubchallenge.features.repo.data.RepoRaw
import com.erel.githubchallenge.features.repo.domain.GetRepoInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepoActivity: BaseActivity() {

    @Inject
    lateinit var repoInteractor: BaseInteractor<GetRepoInteractor.Params, RepoRaw>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.IO){
            val repo = repoInteractor.execute(GetRepoInteractor.Params("ErelOzcakirlar", "MovieDBChallenk"))
            when(repo.type){
                DataHolderType.SUCCESS -> Log.d("RepoDesc", "desc:${repo.data?.owner?.profileImage.orEmpty()}")
                DataHolderType.FAIL -> Log.d("RepoEx", "ex:${repo.error}")
            }

        }

    }
}