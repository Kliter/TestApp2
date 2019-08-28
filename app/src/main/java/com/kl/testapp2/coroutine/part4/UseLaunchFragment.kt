package com.kl.testapp2.coroutine.part4

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.kl.testapp2.R
import com.kl.testapp2.databinding.FragmentUseLaunchBinding
import org.koin.android.ext.android.inject

class UseLaunchFragment : Fragment() {

    companion object {
        fun newInstance() = UseLaunchFragment()
    }

    private val viewModel: UseLaunchViewModel by inject()
    private lateinit var binding: FragmentUseLaunchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_use_launch, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.updateText()
    }
}
