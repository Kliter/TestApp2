package com.kl.testapp2.edittext

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityEditTextTestBinding

class EditTextTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditTextTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showStatusBar()
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_edit_text_test
        )
    }

    private fun showStatusBar() {
        this.window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val decor = this.window.decorView
        decor.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }

    private fun hideStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()
    }
}
