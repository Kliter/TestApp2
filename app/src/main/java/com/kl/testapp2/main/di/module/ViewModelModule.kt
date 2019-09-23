package com.kl.testapp2.main.di.module

import com.kl.testapp2.coroutine.part1.FirstCoroutineViewModel
import com.kl.testapp2.coroutine.part2.UseRunBlockingViewModel
import com.kl.testapp2.coroutine.part3.WaitJobViewModel
import com.kl.testapp2.coroutine.part4.UseLaunchViewModel
import com.kl.testapp2.coroutine.part5.UseAsyncViewModel
import com.kl.testapp2.epoxy.viewmodel.ContentFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.ContentSecondViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderFirstViewModel
import com.kl.testapp2.epoxy.viewmodel.HeaderSecondViewModel
import com.kl.testapp2.flow.presentation.FlowTestViewModel
import com.kl.testapp2.koin.viewmodel.KoinTestViewModel
import com.kl.testapp2.room.RoomTestViewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val viewModelModule: Module = module {
    factory { KoinTestViewModel(get()) }
    factory { HeaderFirstViewModel() }
    factory { HeaderSecondViewModel() }
    factory { ContentFirstViewModel() }
    factory { ContentSecondViewModel() }
    factory { FirstCoroutineViewModel() }
    factory { UseRunBlockingViewModel() }
    factory { WaitJobViewModel() }
    factory { UseLaunchViewModel() }
    factory { UseAsyncViewModel() }
    factory { FlowTestViewModel(get()) }
    factory { RoomTestViewModel() }
}