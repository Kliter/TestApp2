package com.kl.testapp2.main.di

import android.app.Application
import com.kl.testapp2.koin.contract.GreetingRepositoryContract
import com.kl.testapp2.koin.repository.GreetingRepository
import com.kl.testapp2.main.di.module.serviceModule
import com.kl.testapp2.main.di.module.viewModelModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this, listOf(
                this.repositoryModule,
                viewModelModule,
                serviceModule
            )
        )
    }

    private val repositoryModule: Module = module {
        factory { GreetingRepository() as GreetingRepositoryContract }
    }
}
