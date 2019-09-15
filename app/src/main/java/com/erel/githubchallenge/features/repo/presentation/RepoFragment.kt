package com.erel.githubchallenge.features.repo.presentation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.erel.githubchallenge.R
import com.erel.githubchallenge.core.presentation.BaseFragment
import com.erel.githubchallenge.features.user.presentation.UserActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_repo.*

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
            textRepoIdentifier.text = getString(R.string.repo_identifier_format, it.owner.id, it.name)
            textMail.text = it.owner.email
            textLanguage.text = it.language
            textStars.text = getString(R.string.repo_stars_format, it.starsCount)
            textForks.text = getString(R.string.repo_forks_format, it.forksCount)
            textWatchers.text = getString(R.string.repo_watchers_format, it.watchersCount)
            Picasso.get().load(it.owner.profileImage).fit().centerCrop().into(imageOwnerAvatar)
            imageOwnerAvatar.setOnClickListener { _ ->
                startActivity(UserActivity.callingIntent(requireContext(), it.owner.id))
            }
        })
    }

    companion object {

        const val ARG_KEY_USER = "user"
        const val ARG_KEY_REPO = "repo"

        fun newInstance(user: String, repo: String) = RepoFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_KEY_USER, user)
                putString(ARG_KEY_REPO, repo)
            }
        }
    }

}