package com.kl.testapp2.listadapter

import androidx.recyclerview.widget.DiffUtil

class DiffUtil : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem == newItem

    override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id
}