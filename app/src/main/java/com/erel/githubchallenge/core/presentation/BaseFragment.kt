package com.erel.githubchallenge.core.presentation

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.erel.githubchallenge.R
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment<ViewModel : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ViewModel

    abstract val modelClass: Class<ViewModel>
    abstract val layoutRes: Int

    abstract fun observeViewModel()

    override fun onAttach(context: Context) {
        if (activity is HasSupportFragmentInjector) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(modelClass)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(layoutRes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeBaseViewModel()
        observeViewModel()
    }

    private fun observeBaseViewModel() = with(viewModel) {
        errorLiveData.observe(viewLifecycleOwner, Observer {
            val dialog = with(AlertDialog.Builder(requireContext())) {
                setTitle(R.string.dialog_title_error)
                setMessage(it)
                setPositiveButton(R.string.dialog_action_ok) { dialog, _ -> dialog.dismiss() }
                create()
            }
            dialog.show()
        })
        progressLiveData.observe(viewLifecycleOwner, Observer {
            (requireActivity() as? BaseActivity)?.setProgress(it)
        })
    }
}