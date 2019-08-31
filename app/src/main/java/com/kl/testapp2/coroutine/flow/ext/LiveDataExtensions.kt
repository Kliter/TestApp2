package com.kl.testapp2.coroutine.flow.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.flow.flowViaChannel

/**
 * Flow
 * Coroutineを使用して、
 * 非同期でコールドストリームを利用する仕組み。
 *
 *
 */

/**
 * asFlow()
 * LiveDataをFlowとして扱うための拡張関数。
 */
/**
 * flowViaChannel
 * Flowを作成するためのFlowBuilderの一つ。
 */
fun <T> LiveData<T>.asFlow() = flowViaChannel<T?> {
    it.offer(value)
    /**
     * Observer
     * onChanged()を持っている。
     * データが変更された時にonChanged()を実行する。
     * () -> Unitを引数にとる。
     */
    val observer = Observer<T> { t ->
        it.offer(t) // 値が変更されたらそれをFlowに流すObserver
    }

    /**
     * LiveData#observeForever()
     * 引数に渡されたObserverをObserverのリストに加える。
     * 渡されたObserverは全てのイベントを受け取り、自動的にremoveされることはない。
     * removeObserverを実行すればObserveを中止することができる。
     * LiveData既にObserverを持っていた場合、IllegalArgumentExceptionが投げられる。
     */
    /**
     * LiveDataに拡張関数を追加しているので、
     * LiveDataが持つ他のインスタンスメソッドを参照することができる。
     */
    observeForever(observer)
    it.invokeOnClose {
        removeObserver(observer)
    }
}