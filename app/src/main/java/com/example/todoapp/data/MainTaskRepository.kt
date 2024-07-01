package com.example.todoapp.data

import com.example.todoapp.data.local.LocalTask
import com.example.todoapp.data.local.TaskDao
import com.example.todoapp.data.local.TaskDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject
import javax.sql.DataSource

class MainTaskRepository @Inject constructor(
    private val localDataSource: TaskDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
    ): TaskRepository {

    override suspend fun createTask(title: String, description: String): String {
        val taskId =  withContext(dispatcher){
            UUID.randomUUID().toString()
        }
        val task = Task(
            id = taskId,
            title = title,
            description = description,
            completed = false
        )
        localDataSource.upsert(task.toLocal())
        return taskId
    }

    override suspend fun getAllTasks(): List<LocalTask>  = withContext(dispatcher){
        localDataSource.getAll()
    }
}