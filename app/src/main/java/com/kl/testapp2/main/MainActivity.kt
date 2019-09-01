package com.kl.testapp2.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.coroutine.CoroutineActivity
import com.kl.testapp2.databinding.ActivityMainBinding
import com.kl.testapp2.epoxy.view.EpoxyActivity
import com.kl.testapp2.flow.presentation.FlowTestActivity
import com.kl.testapp2.koin.view.KoinActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.onClickListener = this
    }

    override fun onClick(view: View?) {
        val intent = Intent()
        when (view?.id) {
            R.id.btn_epoxy_test -> {
                intent.setClass(this, EpoxyActivity::class.java)
            }
            R.id.btn_koin_test -> {
                intent.setClass(this, KoinActivity::class.java)
            }
            R.id.btn_coroutine_test -> {
                intent.setClass(this, CoroutineActivity::class.java)
            }
            R.id.btn_flow_test -> {
                intent.setClass(this, FlowTestActivity::class.java)
            }
        }
        startActivity(intent)
    }
}
