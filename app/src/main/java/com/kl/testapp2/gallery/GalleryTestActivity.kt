package com.kl.testapp2.gallery

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityGalleryTestBinding
import kotlinx.android.synthetic.main.activity_gallery_test.*
import org.koin.android.ext.android.inject

class GalleryTestActivity : AppCompatActivity() {


    companion object {
        private const val TAG = "GalleryTestActivity"
        private const val REQUEST_CODE_GALLERY = 9000
        private const val INTENT_TYPE_GALLERY_IMAGE = "image/*"
    }

    private val _viewModel: GalleryTestViewModel by inject()
    private var binding: ActivityGalleryTestBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_test)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery_test)
        binding.apply {
            this?.viewModel = _viewModel
            this?.onClickOpenGalleryBtn = View.OnClickListener {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = INTENT_TYPE_GALLERY_IMAGE
                startActivityForResult(intent, REQUEST_CODE_GALLERY)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == Activity.RESULT_OK) {
            val result = data?.data
            selected_image.setImageBitmap(
                MediaStore.Images.Media.getBitmap(
                    contentResolver,
                    result
                )
            )
            Log.d(TAG, result.toString())
        }
    }
}
