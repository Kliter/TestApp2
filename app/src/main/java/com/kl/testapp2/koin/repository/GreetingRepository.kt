package com.kl.testapp2.koin.repository

import com.kl.testapp2.koin.contract.GreetingRepositoryContract

class GreetingRepository: GreetingRepositoryContract {

    companion object {

    }

    override fun morningGreet() = "Good Morning"
    override fun afternoonGreet() = "Good Afternoon"
    override fun eveningGreet () = "Good Evening"

}