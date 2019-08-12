package com.kl.testapp2.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityMainBinding
import com.kl.testapp2.epoxy.EpoxyActivity
import com.kl.testapp2.koin.view.KoinActivity

class MainActivity : AppCompatActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
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
        }
        startActivity(intent)
    }
}
