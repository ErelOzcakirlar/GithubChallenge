package com.erel.githubchallenge.features.user.presentation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.erel.githubchallenge.R
import com.erel.githubchallenge.core.presentation.BaseFragment

class UserFragment : BaseFragment<UserViewModel>() {

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
        viewModel.getUser(user)
    }

    override fun observeViewModel() = with(viewModel) {
        userLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("User", "Avatar:${it.profileImage}")
            Log.d("User", "First Repo:${it.repos[0].name}")
        })
    }

    companion object {

        private const val ARG_KEY_USER = "user"

        fun newInstance(user: String) = UserFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_KEY_USER, user)
            }
        }
    }
}