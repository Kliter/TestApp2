package com.kl.testapp2.koin.viewmodel

import androidx.lifecycle.ViewModel
import com.kl.testapp2.koin.contract.GreetingRepositoryContract

class KoinTestViewModel(
    private val repository: GreetingRepositoryContract
): ViewModel() {

    var caption: String? = null

    fun greet () {
        caption = repository.morningGreet()
    }
}