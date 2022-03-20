package com.dsrise.kotlinkoin.di.service

import android.util.Log
import com.dsrise.kotlinkoin.utils.Constants

interface FakeAnalyticsService {
    fun onTrack(eventName: String, eventType: String)
}

class FirebaseAnalytics : FakeAnalyticsService {
    override fun onTrack(eventName: String, eventType: String) {
        Log.d(
            Constants.APP_LOGGER_TAG, "FirebaseAnalytics :: onTrack <>" +
                    " { eventName :$eventName :: eventType : $eventType } "
        )
    }
}

class MixPanelAnalytics : FakeAnalyticsService {
    override fun onTrack(eventName: String, eventType: String) {
        Log.d(
            Constants.APP_LOGGER_TAG, "MixPanelAnalytics :: onTrack <>" +
                    " { eventName :$eventName :: eventType : $eventType } "
        )
    }
}

class Main(private val firebaseAnalytics: FirebaseAnalytics,private val mixPanelAnalytics: MixPanelAnalytics)
{
    fun getAnalytics()
    {
        firebaseAnalytics.onTrack("CREATING PROFILE","CRUD")
        mixPanelAnalytics.onTrack("CREATING PROFILE","CRUD")
    }
}