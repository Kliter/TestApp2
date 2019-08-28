package com.kl.testapp2.coroutine.part5

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.kl.testapp2.R
import com.kl.testapp2.databinding.FragmentUseAsyncBinding
import org.koin.android.ext.android.inject

class UseAsyncFragment : Fragment() {

    companion object {
        fun newInstance() = UseAsyncFragment()
    }

    private val viewModel: UseAsyncViewModel by inject()
    private lateinit var binding: FragmentUseAsyncBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_use_async, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.updateText()
    }

}
