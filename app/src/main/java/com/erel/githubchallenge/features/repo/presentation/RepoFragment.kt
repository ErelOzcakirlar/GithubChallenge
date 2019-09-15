package com.erel.githubchallenge.features.repo.presentation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.erel.githubchallenge.R
import com.erel.githubchallenge.core.presentation.BaseFragment

class RepoFragment : BaseFragment<RepoViewModel>() {

    override val modelClass: Class<RepoViewModel>
        get() = RepoViewModel::class.java

    override val layoutRes: Int
        get() = R.layout.fragment_repo

    lateinit var user: String
    lateinit var repo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getString(ARG_KEY_USER).orEmpty()
            repo = it.getString(ARG_KEY_REPO).orEmpty()
        }
        viewModel.getRepo(user, repo)
    }

    override fun observeViewModel() = with(viewModel) {
        repoLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("Repo", "Avatar:${it.owner.profileImage}")
        })
    }

    companion object {

        private const val ARG_KEY_USER = "user"
        private const val ARG_KEY_REPO = "repo"

        fun newInstance(user: String, repo: String) = RepoFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_KEY_USER, user)
                putString(ARG_KEY_REPO, repo)
            }
        }
    }

}