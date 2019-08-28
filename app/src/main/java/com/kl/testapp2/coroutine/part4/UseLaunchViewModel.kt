package com.kl.testapp2.coroutine.part4

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UseLaunchViewModel : ViewModel() {

    var text: String = ""

    /**
     * 実行結果
     * 1
     * 3
     * 2
     */
    fun updateText() {
        println(1)
        text = "1"
        GlobalScope.launch { // runBlockingがないのでメインスレッドはブロックされない。
            println(2)
            text = "2"
        }
        println(3)
        text = "3"
    }

    /**
     * launchの引数で実行するスレッドを指定できる。
     * 引数なしで実行した場合はDispatchers.Defaultが使用される。
     *
     * Dispatchers.Default -> バックグラウンドスレッド
     * Dispatchers.UI      -> メインスレッド
     *
     *
     */


}
