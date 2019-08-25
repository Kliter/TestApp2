package com.kl.testapp2.coroutine.part1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

/**
 * 基本的に、コルーチンは軽量スレッド。
 * CoroutineはCoroutineのコンテキスト内でlaunchコルーチンビルダーによって起動される。
 *
 * GlobalScope：アプリケーション全体の存続期間によってのみ制限される。
 * つまり、アプリケーションライフサイクルがこのコルーチンに適用されるということ。
 */

class FirstCoroutineViewModel : ViewModel() {

    var text: MutableLiveData<String> = MutableLiveData()

    fun updateText() {
        GlobalScope.launch {
            // delayはMainスレッドをブロックしないように、コルーチンを中断できる。
            // 通称「ノンブロッキング関数」「suspend関数」
            // public suspend fun delay(timeMillis: Long) {
            delay(1000L)
            text.postValue("World!")
        }

        text.postValue("Hello!")
        Thread.sleep(2000L)
    }
}
