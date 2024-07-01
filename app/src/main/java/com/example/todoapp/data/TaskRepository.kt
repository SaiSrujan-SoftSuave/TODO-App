package com.example.todoapp.data

import com.example.todoapp.data.local.LocalTask

interface TaskRepository {

    suspend fun createTask(title:String, description:String):String

    suspend fun getAllTasks():List<LocalTask>
}