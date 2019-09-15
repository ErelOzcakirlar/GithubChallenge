package com.erel.githubchallenge.features.repo.presentation

import android.content.Context
import android.content.Intent
import com.erel.githubchallenge.core.extensions.EMPTY
import com.erel.githubchallenge.core.presentation.BaseActivity

class RepoActivity : BaseActivity() {

    override fun getFragmentInstance() =
        RepoFragment.newInstance(
            intent.getStringExtra(RepoFragment.ARG_KEY_USER) ?: EMPTY,
            intent.getStringExtra(RepoFragment.ARG_KEY_REPO) ?: EMPTY
        )

    companion object {
        fun callingIntent(context: Context, user: String, repo: String) =
            Intent(context, RepoActivity::class.java).apply {
                putExtra(RepoFragment.ARG_KEY_USER, user)
                putExtra(RepoFragment.ARG_KEY_REPO, repo)
            }
    }
}