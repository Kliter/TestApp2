package com.kl.testapp2.flow.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityFlowTestBinding
import com.kl.testapp2.flow.presentation.view.RepoListAdapter
import org.koin.android.ext.android.inject

class FlowTestActivity : AppCompatActivity() {

    private val _viewModel: FlowTestViewModel by inject()
    private val binding: ActivityFlowTestBinding by lazy {
        DataBindingUtil.setContentView<ActivityFlowTestBinding>(this, R.layout.activity_flow_test)
    }
    private val _adapter = RepoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            viewModel = _viewModel
            lifecycleOwner = this@FlowTestActivity
            binding.recyclerView.adapter = _adapter
        }
        _viewModel.repos.observe(this, Observer { repos ->
            repos?.let { _adapter.repos = it }
            _adapter.notifyDataSetChanged()
        })
    }
}
