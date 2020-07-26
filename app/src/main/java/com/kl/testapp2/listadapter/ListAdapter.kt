package com.kl.testapp2.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import com.kl.testapp2.databinding.ItemUserBinding

class ListAdapter : ListAdapter<User, UserViewHolder>(DiffUtil()) {

    private var expandedIds = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.executeAfter {
            this.user = data
            isExpanded = expandedIds.contains(data.id)
        }
        holder.binding.user = data
        holder.binding.setOnClickItem {
            val parent = holder.itemView.parent as? ViewGroup ?: return@setOnClickItem
            val isExpanded = holder.binding.isExpanded ?: false
            if (isExpanded) {
                expandedIds.remove(data.id)
            } else {
                expandedIds.add(data.id)
            }

            val transition = TransitionInflater.from(holder.binding.root.context)
                .inflateTransition(android.R.transition.move)
            TransitionManager.beginDelayedTransition(parent, transition)
            holder.binding.executeAfter {
                this.isExpanded = !isExpanded
            }
        }
    }
}

inline fun <T : ViewDataBinding> T.executeAfter(block: T.() -> Unit) {
    block()
    executePendingBindings()
}