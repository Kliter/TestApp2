package com.kl.testapp2.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.coroutine.CoroutineActivity
import com.kl.testapp2.databinding.ActivityMainBinding
import com.kl.testapp2.edittext.EditTextTestActivity
import com.kl.testapp2.epoxy.view.EpoxyActivity
import com.kl.testapp2.epoxymodelchange.SampleActivity
import com.kl.testapp2.flow.presentation.FlowTestActivity
import com.kl.testapp2.gallery.GalleryTestActivity
import com.kl.testapp2.koin.view.KoinActivity
import com.kl.testapp2.listadapter.ListAdapterTestActivity
import com.kl.testapp2.navigation.NavigationTestActivity

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
            R.id.btn_navigation_test -> {
                intent.setClass(this, NavigationTestActivity::class.java)
            }
            R.id.btn_gallery_test -> {
                intent.setClass(this, GalleryTestActivity::class.java)
            }
            R.id.btn_edit_text_test -> {
                intent.setClass(this, EditTextTestActivity::class.java)
            }
            R.id.btn_epoxy_model_change_test -> {
                intent.setClass(this, SampleActivity::class.java)
            }
            R.id.btn_list_adapter_test -> {
                intent.setClass(this, ListAdapterTestActivity::class.java)
            }
        }
        startActivity(intent)
    }
}
