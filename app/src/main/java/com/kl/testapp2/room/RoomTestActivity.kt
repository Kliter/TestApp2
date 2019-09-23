package com.kl.testapp2.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kl.testapp2.R
import com.kl.testapp2.databinding.ActivityRoomTestBinding
import org.koin.android.ext.android.inject

class RoomTestActivity : AppCompatActivity() {

    private val _viewModel: RoomTestViewModel by inject()
    private val binding: ActivityRoomTestBinding by lazy {
        DataBindingUtil.setContentView<ActivityRoomTestBinding>(this, R.layout.activity_room_test)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            viewModel = _viewModel
        }
    }
}
