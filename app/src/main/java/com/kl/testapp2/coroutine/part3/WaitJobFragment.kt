package com.kl.testapp2.coroutine.part3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.kl.testapp2.R
import com.kl.testapp2.databinding.FragmentWaitJobBinding
import org.koin.android.ext.android.inject

class WaitJobFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = WaitJobFragment()
    }

    private val viewModel: WaitJobViewModel by inject()
    private lateinit var binding: FragmentWaitJobBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wait_job, container, false)
        binding.viewModel = viewModel
        binding.onClickListener = this
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_wait_job -> {
                viewModel.updateText()
            }
        }
    }
}
