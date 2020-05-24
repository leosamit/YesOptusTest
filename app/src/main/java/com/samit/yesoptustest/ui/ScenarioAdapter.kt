package com.samit.yesoptustest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samit.yesoptustest.data.OptusUI
import com.samit.yesoptustest.databinding.ItemScenarioBinding
import io.reactivex.subjects.PublishSubject

class ScenarioAdapter : ListAdapter<OptusUI, ScenarioAdapter.ScenarioViewHolder>(
    ScenarioDiffCallback()
) {
    private val itemClickPublish = PublishSubject.create<OptusUI>()
    val itemClicks = itemClickPublish

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScenarioViewHolder {
        return ScenarioViewHolder(
            ItemScenarioBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClickPublish
        )
    }

    override fun onBindViewHolder(holder: ScenarioViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class ScenarioViewHolder(
        private val binding: ItemScenarioBinding, private val itemClicks: PublishSubject<OptusUI>
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