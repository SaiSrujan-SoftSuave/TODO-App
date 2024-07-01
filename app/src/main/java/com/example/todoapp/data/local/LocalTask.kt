package com.example.todoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class LocalTask(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val completed: Boolean
)
