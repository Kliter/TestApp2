package com.kl.testapp2.coroutine.buttons

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.coroutine.part1.FirstCoroutineFragment
import com.kl.testapp2.coroutine.part2.UseRunBlockingFragment
import com.kl.testapp2.coroutine.part3.WaitJobFragment
import com.kl.testapp2.databinding.FragmentCoroutineButtonsBinding

class CoroutineButtonsFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = CoroutineButtonsFragment()
    }

    private lateinit var viewModel: CoroutineButtonsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<FragmentCoroutineButtonsBinding>(
                inflater,
                R.layout.fragment_coroutine_buttons,
                container,
                false
            )
        binding.onClickListener = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CoroutineButtonsViewModel::class.java)
    }

    override fun onClick(view: View?) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.addToBackStack(null)
        when (view?.id) {
            R.id.btn_first_coroutine -> {
                transaction?.replace(
                    R.id.activity_coroutine_container,
                    FirstCoroutineFragment.newInstance()
                )
            }
            R.id.btn_use_runblocking -> {
                transaction?.replace(
                    R.id.activity_coroutine_container,
                    UseRunBlockingFragment.newInstance()
                )
            }
            R.id.btn_wait_job -> {
                transaction?.replace(
                    R.id.activity_coroutine_container,
                    WaitJobFragment.newInstance()
                )
            }
        }
        transaction?.commit()
    }
}