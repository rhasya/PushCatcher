package com.snowfall.pushcatcher

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class MyNLService : NotificationListenerService() {
    companion object {
        private const val TAG = "MyNLService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    /**
     * Execute when notification posted
     */
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)

        Log.d(TAG, "onNotificationPosted")
    }
}
