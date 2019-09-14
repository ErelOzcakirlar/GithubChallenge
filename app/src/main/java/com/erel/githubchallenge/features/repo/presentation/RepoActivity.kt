package com.erel.githubchallenge.features.repo.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.erel.githubchallenge.features.repo.data.RepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepoActivity: AppCompatActivity() {

    @Inject
    lateinit var repoRepository: RepoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.IO){
            val repo = repoRepository.getRepo("square", "retrofit")
            Log.d("RepoDesc", "desc:${repo.description}")
        }

    }
}