package com.kl.testapp2.coroutine.part3

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kl.testapp2.R

class WaitJobFragment : Fragment() {

    companion object {
        fun newInstance() = WaitJobFragment()
    }

    private lateinit var viewModel: WaitJobViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wait_job, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WaitJobViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
