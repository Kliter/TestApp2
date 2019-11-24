package com.kl.testapp2.koin.viewmodel

import androidx.lifecycle.ViewModel
import com.kl.testapp2.koin.contract.GreetingRepositoryContract
import com.kl.testapp2.main.di.module.HogeParent

class KoinTestViewModel(
    private val repository: GreetingRepositoryContract,
    val hogeA: HogeParent,
    val hogeB: HogeParent
) : ViewModel() {

    var caption: String? = null

    fun greet() {
        caption = repository.morningGreet()
    }
}