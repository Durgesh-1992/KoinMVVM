package com.dsrise.kotlinkoin.di.module

import android.util.Log
import com.dsrise.kotlinkoin.utils.Constants
import com.dsrise.kotlinkoin.view.HomeActivity
import org.koin.dsl.module

class ScopedComponent {
    fun getPersonalScope() {
        Log.d(
            Constants.APP_LOGGER_TAG,
            "ScopedComponent :: getPersonalScope: { This is my personal scope } "
        )
    }
}

val scopeModule = module {
    scope<HomeActivity> {
        scoped { ScopedComponent() }
    }
}