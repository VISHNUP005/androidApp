package com.example.vwork.models

data class Message(
    val senderId: String,
    val receiverId: String,
    val message: String,
    val timestamp: Long
)