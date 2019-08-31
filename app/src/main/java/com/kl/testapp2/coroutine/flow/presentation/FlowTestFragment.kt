package com.kl.testapp2.coroutine.flow.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.kl.testapp2.R
import com.kl.testapp2.coroutine.flow.presentation.view.RepoListAdapter
import com.kl.testapp2.databinding.FragmentFlowTestBinding
import kotlinx.android.synthetic.main.fragment_flow_test.*
import org.koin.android.ext.android.inject

class FlowTestFragment : Fragment() {

    companion object {
        fun newInstance() = FlowTestFragment()
    }

    private val _viewModel: FlowTestViewModel by inject()
    private val binding: FragmentFlowTestBinding by lazy {
        DataBindingUtil.inflate<FragmentFlowTestBinding>(
            layoutInflater,
            R.layout.fragment_flow_test,
            container,
            false
        )
    }
    private val _adapter = RepoListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.apply {
            viewModel = _viewModel
            lifecycleOwner = this@FlowTestFragment
            binding.recyclerView.adapter = _adapter
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        _viewModel.repos.observe(this, Observer { repos ->
            repos?.let { _adapter.repos = it }
            _adapter.notifyDataSetChanged()
        })
    }


}
