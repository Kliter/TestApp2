package com.kl.testapp2.main.di

import android.app.Application
import com.kl.testapp2.koin.contract.GreetingRepositoryContract
import com.kl.testapp2.koin.repository.GreetingRepository
import com.kl.testapp2.koin.viewmodel.KoinTestViewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            this.repositoryModule,
            this.viewModelModule
        ))
    }

    private val repositoryModule: Module = module {
        factory { GreetingRepository() as GreetingRepositoryContract }
    }

    private val viewModelModule: Module = module {
        factory { KoinTestViewModel(get()) }
    }
}
