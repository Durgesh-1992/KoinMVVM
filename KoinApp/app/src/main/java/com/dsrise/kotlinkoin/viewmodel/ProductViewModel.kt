package com.dsrise.kotlinkoin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsrise.daggersampleapp.model.Products
import com.dsrise.kotlinkoin.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {
    val mProduct: LiveData<List<Products>>
        get() = repository.product

    init {
        viewModelScope.launch {
            repository.getProducts()
        }

    }


}