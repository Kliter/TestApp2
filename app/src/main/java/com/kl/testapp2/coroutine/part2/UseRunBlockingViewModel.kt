package com.kl.testapp2.coroutine.part2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * runBlocking
 * 現在のスレッドをブロックする。
 * 「大元のスレッドの処理の流れを横取りする」イメージ。
 * 関数宣言に続けて記述するのが一般的。
 */
class UseRunBlockingViewModel : ViewModel() {

    var text: MutableLiveData<String> = MutableLiveData()

    fun updateText() = runBlocking {
        GlobalScope.launch {
            delay(1000L)
            text.postValue("World!")
        }
        text.postValue("Hello!")

        delay(2000L)
    }
}
