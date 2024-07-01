package com.example.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [LocalTask::class], version = 1)
abstract class TaskDatabase(): RoomDatabase() {
    abstract fun taskDao(): TaskDao
}