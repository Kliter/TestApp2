package com.kl.testapp2.coroutine.part2

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.kl.testapp2.R
import com.kl.testapp2.databinding.FragmentUseRunBlockingBinding
import org.koin.android.ext.android.inject

class UseRunBlockingFragment : Fragment() {

    companion object {
        fun newInstance() = UseRunBlockingFragment()
    }

    private val viewModel: UseRunBlockingViewModel by inject()
    private lateinit var binding: FragmentUseRunBlockingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_use_run_blocking,
            container,
            false
        )

        binding.lifecycleOwner = this@UseRunBlockingFragment
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.updateText()
    }

}
