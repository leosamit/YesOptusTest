package com.samit.yesoptustest.ui.scenario1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.samit.yesoptustest.MainActivity
import com.samit.yesoptustest.R
import com.samit.yesoptustest.databinding.FragmentScenarioOneHomeBinding
import com.samit.yesoptustest.di.injectViewModel
import com.samit.yesoptustest.ui.ScenarioViewModel
import com.samit.yesoptustest.util.ClickHandler
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_scenario_one_home.*
import javax.inject.Inject

class ScenarioOneFragment : DaggerFragment(), ClickHandler {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ScenarioViewModel

    private lateinit var binding: FragmentScenarioOneHomeBinding

    private val args by navArgs<ScenarioOneFragmentArgs>()

    private val actionBar: ActionBar?
        get() = (activity as? MainActivity)?.supportActionBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_scenario_one_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        binding.handler = this
        actionBar?.apply {
            title = getString(R.string.scenario_one)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeButtonEnabled(true)
        }
        viewModel = injectViewModel(viewModelFactory)
        binding.executePendingBindings()
        binding.items = viewModel.scenariosOneItems

        rv_point_items.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        (rv_point_items.adapter as? PointOneItemAdapter)?.run {
            itemClicks.subscribe {
                when (it.id) {
                    1 -> {
                    }

                    2 -> {
                    }

                }
            }
        }
    }

    override fun onBottonClick(v: View) {
        when (v.id) {
            binding.btnColorOne.id -> binding.btnContainer.setBackgroundColor(resources.getColor(R.color.colorRed))

            binding.btnColorTwo.id -> binding.btnContainer.setBackgroundColor(resources.getColor(R.color.colorAccent))

            binding.btnColorThree.id -> binding.btnContainer.setBackgroundColor(resources.getColor(R.color.colorGreen))
        }
    }
}