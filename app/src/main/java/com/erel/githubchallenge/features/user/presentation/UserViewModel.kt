package com.erel.githubchallenge.features.user.presentation

import androidx.lifecycle.MutableLiveData
import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.presentation.BaseViewModel
import com.erel.githubchallenge.features.user.domain.GetUserInteractor
import com.erel.githubchallenge.features.user.domain.UserUI
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val getUserInteractor: BaseInteractor<GetUserInteractor.Params, UserUI>
) : BaseViewModel() {

    val userLiveData = MutableLiveData<UserUI>()

    fun getUser(user: String) =
        runInteractor(getUserInteractor, GetUserInteractor.Params(user)) {
            userLiveData.value = it
        }
}