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
        // TODO: Use the ViewModel
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_first_coroutine -> {
                val transaction = fragmentManager?.beginTransaction()
                transaction?.let {
                    transaction.addToBackStack(null)
                    transaction.replace(
                        R.id.activity_coroutine_container,
                        FirstCoroutineFragment.newInstance()
                    )
                    transaction.commit()
                }
            }
        }
    }
}