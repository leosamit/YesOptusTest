package com.samit.yesoptustest.ui.scenario2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.samit.yesoptustest.MainActivity
import com.samit.yesoptustest.R
import com.samit.yesoptustest.data.Result
import com.samit.yesoptustest.databinding.FragmentScenarioTwoHomeBinding
import com.samit.yesoptustest.di.injectViewModel
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class ScenarioTwoFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ScenarioTwoViewModel

    private lateinit var binding: FragmentScenarioTwoHomeBinding

    private val actionBar: ActionBar?
        get() = (activity as? MainActivity)?.supportActionBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_scenario_two_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        actionBar?.apply {
            title = getString(R.string.scenario_two)
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
            setHomeButtonEnabled(false)
        }
        viewModel = injectViewModel(viewModelFactory)
        binding.executePendingBindings()
        subscribeUI()
    }

    private fun subscribeUI() {
        viewModel.userInfoList.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Result.Status.LOADING -> {
                }

                Result.Status.SUCCESS -> {
                    Timber.d("Samit Subscribe ${result.data}")
                    binding.strings= listOf("ab","bc","cd")
                }
                Result.Status.ERROR -> {
                }
            }
        }
    }

}