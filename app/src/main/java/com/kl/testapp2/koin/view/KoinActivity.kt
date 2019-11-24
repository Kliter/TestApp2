package com.kl.testapp2.koin.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityKoinBinding
import com.kl.testapp2.koin.viewmodel.KoinTestViewModel
import org.koin.android.ext.android.inject

class KoinActivity : AppCompatActivity() {

    private val viewModel: KoinTestViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityKoinBinding>(this, R.layout.activity_koin)

        binding.viewModel = viewModel
        viewModel.greet()

        Log.d("DITest", viewModel.hogeA.text)
        Log.d("DITest", viewModel.hogeB.text)
        
    }
}
