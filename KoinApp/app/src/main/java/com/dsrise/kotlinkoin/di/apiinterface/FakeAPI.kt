package com.dsrise.kotlinkoin.di.apiinterface

import com.dsrise.daggersampleapp.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface FakeAPI {

    @GET("products")
    suspend fun getAllProducts(): Response<List<Products>>
}