package com.kl.testapp2.main.di.module

import com.kl.testapp2.main.domain.GitHubService
import com.kl.testapp2.main.domain.GitHubServiceImpl
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val serviceModule: Module = module {
    factory { GitHubServiceImpl() as GitHubService }
}