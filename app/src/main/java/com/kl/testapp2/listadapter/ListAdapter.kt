package com.kl.testapp2.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kl.testapp2.databinding.ItemUserBinding

class ListAdapter(var listItems: MutableList<ListItem>) : RecyclerView.Adapter<UserViewHolder>() {

    private var expandedPosition = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.listItem = listItems[position]
        holder.binding.setOnClickItem {
            changeExpandedItem(expandedPosition, position)
        }
    }

    private fun changeExpandedItem(oldPosition: Int, newPosition: Int) {
        // Collapse
        listItems[oldPosition].isExpanded = false
        this.notifyItemChanged(oldPosition)
        // Expand
        listItems[newPosition].isExpanded = true
        this.notifyItemChanged(newPosition)

        expandedPosition = newPosition
    }

    fun expandNextItem() {
        changeExpandedItem(expandedPosition, expandedPosition + 1)
    }

    fun expandPreviousItem() {
        changeExpandedItem(expandedPosition, expandedPosition - 1)
    }
}