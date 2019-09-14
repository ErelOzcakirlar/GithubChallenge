package com.erel.githubchallenge.core.presentation

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        if (activity is HasSupportFragmentInjector) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }
}