package com.kl.testapp2.coroutine.part1

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kl.testapp2.R

class FirstCoroutineFragment : Fragment() {

    companion object {
        fun newInstance() = FirstCoroutineFragment()
    }

    private lateinit var viewModel: FirstCoroutineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_coroutine, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirstCoroutineViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
