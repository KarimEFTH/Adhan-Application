package com.example.salatfirst.data.repository

import com.example.salatfirst.data.model.ReminderData
import com.example.salatfirst.data.network.ApiService

class ReminderRepository(private val apiService: ApiService) {
    suspend fun fetchReminders(): List<ReminderData> {
        return apiService.getReminders()
    }
}