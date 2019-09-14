package com.erel.githubchallenge.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]

        if (creator == null) {
            creators.entries.find { modelClass.isAssignableFrom(it.key) }?.let {
                creator = it.value
            }
        }

        if (creator == null) {
            throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
        }

        try {
            return (creator as Provider<ViewModel>).get() as T
        } catch (ex: Exception) {
            throw RuntimeException(ex)
        }
    }
}