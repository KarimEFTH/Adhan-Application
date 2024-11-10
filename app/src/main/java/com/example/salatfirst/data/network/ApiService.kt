package com.example.salatfirst.data.network

import com.example.salatfirst.data.model.ReminderData
import retrofit2.http.GET

interface ApiService {
    @GET("votre_endpoint")
    suspend fun getReminders(): List<ReminderData>
}