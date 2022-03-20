package com.dsrise.kotlinkoin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dsrise.kotlinkoin.R
import com.dsrise.kotlinkoin.di.module.ScopedComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.component.KoinScopeComponent
import org.koin.core.scope.Scope

class HomeActivity : AppCompatActivity(), KoinScopeComponent {
    override val scope: Scope by activityScope()

    private val scopeComponent: ScopedComponent by scope.inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scopeComponent.getPersonalScope()
    }
}