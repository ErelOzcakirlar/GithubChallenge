package com.erel.githubchallenge.core.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erel.githubchallenge.core.domain.BaseInteractor
import com.erel.githubchallenge.core.domain.DataHolderType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val progressLiveData = MutableLiveData<Boolean>()
    val errorLiveData = SingleLiveEvent<String>()

    inline fun <Params, Response> runInteractor(
        interactor: BaseInteractor<Params, Response>,
        params: Params,
        showProgress: Boolean = true,
        crossinline fail: (String?) -> Unit = {},
        crossinline success: (Response?) -> Unit
    ) {
        if (showProgress) {
            progressLiveData.value = true
        }
        GlobalScope.launch(Dispatchers.IO) {
            val response = interactor.execute(params)
            GlobalScope.launch(Dispatchers.Main) {
                progressLiveData.value = false
                when (response.type) {
                    DataHolderType.SUCCESS -> success(response.data)
                    DataHolderType.FAIL -> {
                        errorLiveData.value = response.error
                        fail(response.error)
                    }
                }
            }
        }
    }
}