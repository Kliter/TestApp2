package com.kl.testapp2.main.di

import android.app.Application
import com.kl.testapp2.coroutine.part1.FirstCoroutineViewModel
import com.kl.testapp2.coroutine.part2.UseRunBlockingViewModel
import com.kl.testapp2.coroutine.part3.WaitJobFragment
import com.kl.testapp2.coroutine.part3.WaitJobViewModel
import com.kl.testapp2.epoxy.viewmodel.ContentFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.ContentSecondViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderSecondViewModel
import com.kl.testapp2.koin.contract.GreetingRepositoryContract
import com.kl.testapp2.koin.repository.GreetingRepository
import com.kl.testapp2.koin.viewmodel.KoinTestViewModel
import com.kl.testapp2.main.di.module.viewModelModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            this.repositoryModule,
            viewModelModule
        ))
    }

    private val repositoryModule: Module = module {
        factory { GreetingRepository() as GreetingRepositoryContract }
    }
}
