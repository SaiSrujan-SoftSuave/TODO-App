package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.MainTaskRepository
import com.example.todoapp.data.TaskRepository
import com.example.todoapp.data.local.TaskDao
import com.example.todoapp.data.local.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 object DatabaseModule {
     @Provides
     fun provideDatabase(@ApplicationContext context: Context): TaskDatabase {
         return Room.databaseBuilder(
             context.applicationContext,
             TaskDatabase::class.java,
             "tasks.db"
         ).build()
     }

    @Provides
    fun provideTaskDao(db: TaskDatabase): TaskDao {
        return db.taskDao()
    }


    @Provides
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository{
        return MainTaskRepository(localDataSource = taskDao)
    }

 }