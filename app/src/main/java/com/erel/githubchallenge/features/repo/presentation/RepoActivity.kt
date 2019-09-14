package com.erel.githubchallenge.features.repo.presentation

import android.os.Bundle
import android.util.Log
import com.erel.githubchallenge.core.presentation.BaseActivity
import com.erel.githubchallenge.features.repo.data.RepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class RepoActivity: BaseActivity() {

    @Inject
    lateinit var repoRepository: RepoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.IO){
            try {
                val repo = repoRepository.getRepo("ErelOzcakirlar", "MovieDBChallenge")
                Log.d("RepoDesc", "desc:${repo.owner?.profileImage.orEmpty()}")
            }catch (ex: HttpException){
                Log.d("RepoEx", "ex:${ex.response()?.errorBody()?.string()}")
            }

        }

    }
}