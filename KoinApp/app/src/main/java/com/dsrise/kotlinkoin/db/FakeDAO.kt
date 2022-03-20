package com.dsrise.kotlinkoin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dsrise.daggersampleapp.model.Products

@Dao
interface FakeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllProducts(productList: List<Products>)

    @Query("SELECT * FROM product")
    suspend fun getAllProducts(): List<Products>
}