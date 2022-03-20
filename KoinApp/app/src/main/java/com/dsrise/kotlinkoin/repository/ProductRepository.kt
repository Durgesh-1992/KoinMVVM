package com.dsrise.kotlinkoin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dsrise.daggersampleapp.model.Products
import com.dsrise.kotlinkoin.db.FakeDB
import com.dsrise.kotlinkoin.di.apiinterface.FakeAPI
import com.dsrise.kotlinkoin.di.service.FakeAnalyticsService

class ProductRepository constructor(
    private val fakerAPI: FakeAPI, private val fakeDB: FakeDB,
    private val fakeAnalyticsService: FakeAnalyticsService
) {
    private val mProducts = MutableLiveData<List<Products>>()
    val product: LiveData<List<Products>>
        get() = mProducts

    suspend fun getProducts() {
        val result = fakerAPI.getAllProducts()
        if (result.isSuccessful && result.body() != null) {
            fakeDB.getFakeDAO().addAllProducts(result.body()!!)
            mProducts.postValue(result.body())
            fakeAnalyticsService.onTrack("ON DATA FETCH SUCCESS", "RETREIVE")
        }
    }
}