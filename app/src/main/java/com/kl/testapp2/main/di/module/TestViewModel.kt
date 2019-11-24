package com.kl.testapp2.main.di.module

import androidx.lifecycle.ViewModel

class TestViewModel(
    val hogeA: HogeParent,
    val hogeB: HogeParent
) : ViewModel() {
}