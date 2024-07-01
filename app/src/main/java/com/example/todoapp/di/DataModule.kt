package com.example.todoapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.MainTaskRepository
import com.example.todoapp.data.TaskRepository
import com.example.todoapp.data.local.TaskDao
import com.example.todoapp.data.local.TaskDatabase
import com.example.todoapp.presentation.screens.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object DatabaseModule {
     @Provides
     @Singleton
     fun provideDatabase(@ApplicationContext context: Context): TaskDatabase {
         return Room.databaseBuilder(
             context,
             TaskDatabase::class.java,
             "tasks.db"
         ).build()
     }

    @Provides
    @Singleton
    fun provideTaskDao(db: TaskDatabase): TaskDao {
        return db.taskDao()
    }


    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository{
        return MainTaskRepository(localDataSource = taskDao)
    }

 }