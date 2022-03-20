package com.dsrise.kotlinkoin.app

import android.app.Application
import com.dsrise.kotlinkoin.di.module.appModule
import com.dsrise.kotlinkoin.di.module.networkModule
import com.dsrise.kotlinkoin.di.module.repositoryModule
import com.dsrise.kotlinkoin.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FakeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@FakeApplication)
            modules(
                appModule
            )
        }
    }
}