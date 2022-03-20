package com.dsrise.kotlinkoin.di.module

import com.dsrise.kotlinkoin.repository.ProductRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule  = module{
    single { ProductRepository(get(),get(),get(named("firebase"))) }
}