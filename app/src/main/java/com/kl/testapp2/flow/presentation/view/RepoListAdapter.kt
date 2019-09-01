package com.kl.testapp2.flow.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kl.testapp2.databinding.ItemListResultBinding
import com.kl.testapp2.flow.model.Repo

class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    var repos: List<Repo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.repoName = repos[position].full_name
    }

    class ViewHolder(val binding: ItemListResultBinding) : RecyclerView.ViewHolder(binding.root)

}