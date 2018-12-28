package com.snowfall.pushcatcher

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
        private const val CHANNEL_ID = "99"
    }

    /**
     * 클래스 생성
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // notification channel 생성
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Oreo 8.0 이상인 경우 채널 생성
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(CHANNEL_ID, "Test Channel", NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "Test Channel"
            }
            manager.createNotificationChannel(channel)
        }

        Log.d(TAG, "onCreate")
    }

    /**
     * 클래스 제거
     */
    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    /**
     * 메뉴 생성
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    /**
     * 메뉴 클릭시 이벤트 처리
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu1 -> {
                val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 테스트 버튼 클릭시 이벤트 처리
     */
    fun onTestClick(view: View) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("TEST")
                .setContentText("TEST" + System.currentTimeMillis())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        NotificationManagerCompat.from(this).notify(2, builder.build())
    }
}
