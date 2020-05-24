package com.samit.yesoptustest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.samit.yesoptustest.MainActivity
import com.samit.yesoptustest.R
import com.samit.yesoptustest.databinding.FragmentScenarioBinding
import com.samit.yesoptustest.di.injectViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_scenario.*
import javax.inject.Inject

class ScenarioFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ScenarioViewModel

    private lateinit var binding: FragmentScenarioBinding

    private val actionBar: ActionBar?
        get() = (activity as? MainActivity)?.supportActionBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scenario, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        actionBar?.apply {
            title = getString(R.string.scenario_home)
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
            setHomeButtonEnabled(false)
        }
        viewModel = injectViewModel(viewModelFactory)
        binding.executePendingBindings()
        binding.scenarios = viewModel.scenarios

        (rv_scenarios.adapter as? ScenarioAdapter)?.run {
            itemClicks.subscribe {
                when (it.id) {
                    1 -> findNavController().navigate(
                        ScenarioFragmentDirections.navigatetoScenarioOne(
                            it
                        )
                    )
                    2 -> {
                    }

                }
            }
        }
    }
}