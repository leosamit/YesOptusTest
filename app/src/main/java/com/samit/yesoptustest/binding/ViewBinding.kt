package com.samit.yesoptustest.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samit.yesoptustest.data.OptusUI
import com.samit.yesoptustest.ui.ScenarioAdapter
import com.samit.yesoptustest.ui.scenario1.PointOneItemAdapter

@BindingAdapter(value = ["app:items"])
fun setScenarios(rv: RecyclerView, items: List<OptusUI>?) {
    if (rv.adapter as? ScenarioAdapter == null) {
        rv.adapter = ScenarioAdapter()
    }
    (rv.adapter as ScenarioAdapter).submitList(items)
}

@BindingAdapter(value = ["app:pointItems"])
fun setPointItems(rv: RecyclerView, items: List<OptusUI>?) {
    if (rv.adapter as? PointOneItemAdapter == null) {
        rv.adapter = PointOneItemAdapter()
    }
    (rv.adapter as PointOneItemAdapter).submitList(items)
}