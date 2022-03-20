package com.dsrise.kotlinkoin.di.module

import com.dsrise.kotlinkoin.di.service.FakeAnalyticsService
import com.dsrise.kotlinkoin.di.service.FirebaseAnalytics
import com.dsrise.kotlinkoin.di.service.Main
import com.dsrise.kotlinkoin.di.service.MixPanelAnalytics
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val interfaceModule = module {
    /**
     * To provide dependency for interface we have three ways
     */
    //Approach 1
//    factory { FirebaseAnalytics() as FakeAnalyticsService }
    //Approach 2
//    factory<FakeAnalyticsService> { FirebaseAnalytics() }
//    factory<FakeAnalyticsService>(named("firebase")) {
//        FirebaseAnalytics()
//    }
//    factory<FakeAnalyticsService>(named("mixpanel")) {
//        MixPanelAnalytics()
//    }
    factory { Main(get(named("firebase")),get(named("mixpanel"))) }
    //Approach 3 (Most recommended way)
    factory(named("firebase")) { FirebaseAnalytics() } bind FakeAnalyticsService::class
    factory(named("mixpanel")) { MixPanelAnalytics() } bind FakeAnalyticsService::class
}