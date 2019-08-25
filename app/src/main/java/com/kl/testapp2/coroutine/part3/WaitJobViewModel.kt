package com.kl.testapp2.coroutine.part3

import android.provider.Settings
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * 別のこルーチンが動作している間遅延させるのはよくない。
 * ex) delay(2000L) みたいな
 *
 * Job#join()
 * 立ち上げたコルーチンが完了するまで待ってくれる。
 *
 * ex)joinの例
 * job.join()
 * →jobのタスクが完了するまで待ってくれる。
 *  2000Lとか書かなくてもよくなる。
 */

class WaitJobViewModel : ViewModel() {

    var text: MutableLiveData<String> = MutableLiveData()

    fun updateText() = runBlocking { // runBlockingなので、Mainスレッドの処理が中断されている。
        val job = GlobalScope.launch {
            delay(5000L)
            text.postValue("World!")
        }

        text.postValue("Hello!")
        job.join()
    }
}
