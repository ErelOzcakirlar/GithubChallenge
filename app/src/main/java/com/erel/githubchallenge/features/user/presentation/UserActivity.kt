package com.erel.githubchallenge.features.user.presentation

import android.content.Context
import android.content.Intent
import com.erel.githubchallenge.core.extensions.EMPTY
import com.erel.githubchallenge.core.presentation.BaseActivity

class UserActivity : BaseActivity() {

    override fun getFragmentInstance() =
        UserFragment.newInstance(intent.getStringExtra(UserFragment.ARG_KEY_USER) ?: EMPTY)

    companion object {
        fun callingIntent(context: Context, user: String) =
            Intent(context, UserActivity::class.java).apply {
                putExtra(UserFragment.ARG_KEY_USER, user)
            }
    }

}