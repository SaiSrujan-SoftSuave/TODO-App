package com.example.todoapp.data

import com.example.todoapp.data.local.LocalTask

data class Task(
    val id: String,
    val title: String,
    val description: String,
    val completed: Boolean
){
    val isEmpty: Boolean
        get() = title.isEmpty() || description.isEmpty()

    val titleOfTask: String
        get() = title.ifEmpty { description }
}

fun Task.toLocal(): LocalTask = LocalTask(
        id = id,
        title = title,
        description = description,
        completed = completed
    )
