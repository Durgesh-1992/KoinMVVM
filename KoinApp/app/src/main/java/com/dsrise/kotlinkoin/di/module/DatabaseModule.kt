package com.dsrise.kotlinkoin.di.module

import android.content.Context
import androidx.room.Room
import com.dsrise.kotlinkoin.db.FakeDB
import com.dsrise.kotlinkoin.utils.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { provideRoomDB(androidContext()) }
}

fun provideRoomDB(context: Context) =
    Room.databaseBuilder(context, FakeDB::class.java, Constants.DB_NAME).allowMainThreadQueries()
        .build()
