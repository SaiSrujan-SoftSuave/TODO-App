package com.example.todoapp.data

import com.example.todoapp.data.local.LocalTask
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun createTask(title:String, description:String):String

    suspend fun getAllTasks():List<LocalTask>

    fun observeAllTasks(): Flow<List<LocalTask>>

    suspend fun updateTask(task:LocalTask)

    suspend fun deleteTask(task:LocalTask)

}