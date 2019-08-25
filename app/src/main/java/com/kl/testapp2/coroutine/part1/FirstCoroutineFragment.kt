package com.kl.testapp2.coroutine.part1

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.kl.testapp2.R
import com.kl.testapp2.databinding.FragmentFirstCoroutineBinding
import kotlinx.android.synthetic.main.fragment_first_coroutine.*
import org.koin.android.ext.android.inject

class FirstCoroutineFragment : Fragment() {

    companion object {
        fun newInstance() = FirstCoroutineFragment()
    }

    private lateinit var binding: FragmentFirstCoroutineBinding
    private val viewModel: FirstCoroutineViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_first_coroutine, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.updateText()
    }
}
