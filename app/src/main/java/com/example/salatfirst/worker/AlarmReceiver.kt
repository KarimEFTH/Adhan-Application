package com.example.salatfirst.worker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.salatfirst.util.NotificationUtils

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val message = intent.getStringExtra("reminder_message") ?: "Rappel"
        NotificationUtils.showNotification(context, message)
    }
}