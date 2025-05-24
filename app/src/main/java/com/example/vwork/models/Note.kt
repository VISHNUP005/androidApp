package com.example.vwork.models

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val timestamp: Long,
    val category: String // "tech" or "daily"
)