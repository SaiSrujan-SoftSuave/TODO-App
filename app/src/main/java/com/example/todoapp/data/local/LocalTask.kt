package com.example.todoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.data.Task

@Entity(tableName = "tasks")
data class LocalTask(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val completed: Boolean
) {

}
fun LocalTask.toTask():Task = Task(id = id, title = title, description = description, completed = completed)
