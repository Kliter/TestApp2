package com.kl.testapp2.coroutine.part1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FirstCoroutineViewModel : ViewModel() {

    var text: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
    }

    fun updateText() {
        GlobalScope.launch {
            delay(1000L)
            text.postValue("World!")
        }

        text.postValue("Hello!")
        Thread.sleep(200L)
    }
}
