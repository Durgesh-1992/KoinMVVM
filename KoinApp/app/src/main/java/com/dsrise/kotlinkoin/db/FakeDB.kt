package com.dsrise.kotlinkoin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dsrise.daggersampleapp.model.Products

@Database(entities = [Products::class],version = 1)
abstract class FakeDB:RoomDatabase() {

    abstract fun getFakeDAO() : FakeDAO
}