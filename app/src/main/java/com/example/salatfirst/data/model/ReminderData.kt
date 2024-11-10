package com.example.salatfirst.data.model

data class ReminderData(
    val id: Int,
    val message: String,
    val time: String // Format "HH:mm" pour les rappels
)