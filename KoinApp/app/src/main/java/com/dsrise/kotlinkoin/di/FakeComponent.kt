package com.dsrise.kotlinkoin.di

import com.dsrise.kotlinkoin.di.service.Main
import com.dsrise.kotlinkoin.viewmodel.ProductViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

//import org.koin.core.KoinComponent
//import org.koin.core.inject

class FakeComponent : KoinComponent {
    /**
     * This class will be used to hold all the dependencies required
     *  by/throughout the application
     */

    val productViewModel: ProductViewModel by inject()

    val main: Main by inject()
}