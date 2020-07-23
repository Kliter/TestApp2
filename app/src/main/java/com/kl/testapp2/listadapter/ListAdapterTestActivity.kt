package com.kl.testapp2.listadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityListAdapterBinding

class ListAdapterTestActivity : AppCompatActivity() {

    val adapter = ListAdapter()

    private lateinit var binding: ActivityListAdapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_adapter)

        adapter.submitList(users)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.setOnClickShuffle {
            adapter.submitList(users.shuffled())
        }
    }
}