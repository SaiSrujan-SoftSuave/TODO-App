package com.example.todoapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.todoapp.data.local.LocalTask
import com.example.todoapp.data.local.TaskDao
import com.example.todoapp.data.local.TaskDatabase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
@SmallTest
class TaskDaoTest {
    private lateinit var database: TaskDatabase
    private lateinit var taskDao: TaskDao

    @Before
    fun createDb() {
        database =
            Room.inMemoryDatabaseBuilder(getApplicationContext(), TaskDatabase::class.java).build()
        taskDao = database.taskDao()
    }

    @After
    fun closeDb() {
        database.close()
    }

    //Adding test cases
    @Test
    fun insertLocalTaskThenGetItById() = runTest {
        val localTask = LocalTask(
            id = "id",
            title = "title",
            description = "description",
            completed = false
        )
        taskDao.upsert(task = localTask)
        val task = taskDao.getById("id")
        assertEquals(task.title, localTask.title)
        assertEquals(task.id, localTask.id)
        assertEquals(task.description, localTask.description)
        assertEquals(task.completed, localTask.completed)
    }


}