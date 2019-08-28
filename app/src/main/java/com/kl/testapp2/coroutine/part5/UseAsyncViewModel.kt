package com.kl.testapp2.coroutine.part5

import android.provider.Settings
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class UseAsyncViewModel : ViewModel() {

    var text: String = ""

    fun updateText() {

        /**
         * GlobalScope.async
         * 戻り値としてDeferred<T>を返すコルーチンビルダー。
         *
         * Job.join()同様、Deferred<T>#await()を使用すれば、
         * 呼び出し先のコルーチンの終了まで呼び出し元のコルーチンを中断することができる。
         *
         */

        println("1")
        text = "1"

        runBlocking {
            val deferred = GlobalScope.async {
                println("2")
                text = "2"
            }.await()
        }

        println("3")
        text = "3"
    }
}
