package com.erel.githubchallenge.features.user.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.erel.githubchallenge.R
import com.erel.githubchallenge.core.presentation.BaseFragment
import com.erel.githubchallenge.features.repo.presentation.RepoActivity
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment<UserViewModel>() {

    private lateinit var userAdapter: UserAdapter

    override val modelClass: Class<UserViewModel>
        get() = UserViewModel::class.java

    override val layoutRes: Int
        get() = R.layout.fragment_user

    lateinit var user: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getString(ARG_KEY_USER).orEmpty()
        }
        userAdapter = UserAdapter().apply {
            repoClickListener = { user, repo ->
                startActivity(RepoActivity.callingIntent(requireContext(), user, repo))
            }
        }
        viewModel.getUser(user)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerUserAndRepos) {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun observeViewModel() = with(viewModel) {
        userLiveData.observe(viewLifecycleOwner, Observer {
            userAdapter.setData(it)
        })
    }

    companion object {

        const val ARG_KEY_USER = "user"

        fun newInstance(user: String) = UserFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_KEY_USER, user)
            }
        }
    }
}