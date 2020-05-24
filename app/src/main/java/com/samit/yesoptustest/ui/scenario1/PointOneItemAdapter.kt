package com.samit.yesoptustest.ui.scenario1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samit.yesoptustest.data.OptusUI
import com.samit.yesoptustest.databinding.ItemScenarioonePointOneBinding
import io.reactivex.subjects.PublishSubject

class PointOneItemAdapter : ListAdapter<OptusUI, PointOneItemAdapter.ScenarioViewHolder>(
    ScenarioDiffCallback()
) {
    private val itemClickPublish = PublishSubject.create<OptusUI>()
    val itemClicks = itemClickPublish

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScenarioViewHolder {
        return ScenarioViewHolder(
            ItemScenarioonePointOneBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClickPublish
        )
    }

    override fun onBindViewHolder(holder: ScenarioViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class ScenarioViewHolder(
        private val binding: ItemScenarioonePointOneBinding,
        private val itemClicks: PublishSubject<OptusUI>
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(optusUI: OptusUI) {
            binding.text = optusUI.text
            binding.root.setOnClickListener {
                itemClicks.onNext(optusUI)
            }
        }
    }
}

class ScenarioDiffCallback : DiffUtil.ItemCallback<OptusUI>() {
    override fun areItemsTheSame(oldItem: OptusUI, newItem: OptusUI): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: OptusUI, newItem: OptusUI): Boolean {
        return oldItem == newItem
    }
}