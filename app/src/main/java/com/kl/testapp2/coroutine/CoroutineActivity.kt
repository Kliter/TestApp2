package com.kl.testapp2.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.coroutine.buttons.CoroutineButtonsFragment
import com.kl.testapp2.coroutine.part1.FirstCoroutineFragment
import com.kl.testapp2.databinding.ActivityCoroutineBinding

class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCoroutineBinding>(
            this,
            R.layout.activity_coroutine
        )

        val transaction = supportFragmentManager?.beginTransaction()
        transaction?.let {
            transaction.addToBackStack(null)
            transaction.replace(
                R.id.activity_coroutine_container,
                CoroutineButtonsFragment.newInstance()
            )
            transaction.commit()
        }
    }
}
