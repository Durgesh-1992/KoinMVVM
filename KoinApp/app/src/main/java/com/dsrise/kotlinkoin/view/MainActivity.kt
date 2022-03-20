package com.dsrise.kotlinkoin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import com.dsrise.kotlinkoin.R
import com.dsrise.kotlinkoin.di.FakeComponent

class MainActivity : AppCompatActivity() {
    private val productTv: TextView
        get() = findViewById(R.id.productTv)

//    val productViewModel: ProductViewModel by viewModel()
     val fakeComponent = FakeComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fakeComponent.productViewModel.mProduct.observe(this, Observer {
            productTv.text = it.joinToString { x -> x.title + "\n\n" }
        })
        fakeComponent.main.getAnalytics()

    }
}