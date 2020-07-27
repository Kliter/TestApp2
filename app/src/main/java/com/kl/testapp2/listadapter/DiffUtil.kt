package com.kl.testapp2.listadapter

import androidx.recyclerview.widget.DiffUtil

class DiffUtil : DiffUtil.ItemCallback<ListItem>() {

    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem) = oldItem === newItem

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem) =
        oldItem.user.id == newItem.user.id
}