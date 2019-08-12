package com.kl.testapp2.epoxy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityEpoxyBinding
import com.kl.testapp2.epoxy.data.EpoxyData
import com.kl.testapp2.epoxy.viewmodel.ContentFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.ContentSecondViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderSecondViewModel
import com.kl.testapp2.koin.viewmodel.KoinTestViewModel
import org.koin.android.ext.android.inject

class EpoxyActivity : AppCompatActivity() {

    private val headerFirstViewModel: HeaderFirstViewModel by inject()
    private val headerSecondViewModel: HeaderSecondViewModel by inject()
    private val contentFirstViewModel: ContentFirstViewModel by inject()
    private val contentSecondViewModel: ContentSecondViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setController()
    }

    private fun setController() {
        val binding = DataBindingUtil.setContentView<ActivityEpoxyBinding>(this, R.layout.activity_epoxy)
        val controller = EpoxyController()
        controller.setData(EpoxyData(headerFirstViewModel, contentFirstViewModel, headerSecondViewModel, contentSecondViewModel))
        binding.epoxyRecyclerView.adapter = controller.adapter
        binding.epoxyRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}