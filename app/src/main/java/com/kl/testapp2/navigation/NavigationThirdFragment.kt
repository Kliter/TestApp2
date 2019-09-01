package com.kl.testapp2.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.kl.testapp2.R
import kotlinx.android.synthetic.main.fragment_navigation_third.*

class NavigationThirdFragment : Fragment() {

    companion object {
        fun newInstance() = NavigationThirdFragment()
    }

    private lateinit var viewModel: NavigationThirdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_navigation_third, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_third_to_first)
        }
        viewModel = ViewModelProviders.of(this).get(NavigationThirdViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
