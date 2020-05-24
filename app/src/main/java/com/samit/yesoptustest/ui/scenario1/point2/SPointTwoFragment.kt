package com.samit.yesoptustest.ui.scenario1.point2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.samit.yesoptustest.R
import com.samit.yesoptustest.databinding.FragmentViewpagerBinding
import dagger.android.support.DaggerFragment

class SPointTwoFragment : DaggerFragment() {

    private val ARG_COUNT = "param1"
    private var counter: Int = 0
    private lateinit var binding: FragmentViewpagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_viewpager, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            counter = arguments!!.getInt(ARG_COUNT)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text = counter.toString()
        binding.viewPagerContent.setOnClickListener {
            Toast.makeText(view.context, binding.tvFragment.text, Toast.LENGTH_SHORT).show()
        }
    }

    fun newInstance(counter: Int?): SPointTwoFragment? {
        val fragment = SPointTwoFragment()
        val args = Bundle()
        args.putInt(ARG_COUNT, counter!!)
        fragment.arguments = args
        return fragment
    }
}