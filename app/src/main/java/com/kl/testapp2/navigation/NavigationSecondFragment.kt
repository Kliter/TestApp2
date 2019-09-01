package com.kl.testapp2.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.kl.testapp2.R
import kotlinx.android.synthetic.main.fragment_navigation_second.*

class NavigationSecondFragment : Fragment() {

    companion object {
        fun newInstance() = NavigationSecondFragment()
    }

    private lateinit var viewModel: NavigationSecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_navigation_second, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_second_to_third)
        }
        viewModel = ViewModelProviders.of(this).get(NavigationSecondViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
