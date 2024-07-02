package com.example.todoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.Task
import com.example.todoapp.data.TaskRepository
import com.example.todoapp.data.local.toTask
import com.example.todoapp.data.toLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val taskRepository: TaskRepository) : ViewModel() {


    private val _taskLists: MutableStateFlow<List<Task>> = MutableStateFlow(emptyList())
    val taskLists: StateFlow<List<Task>> = _taskLists.asStateFlow()

    init {
        println("Hello988 viewModel")
        viewModelScope.launch {
            taskRepository.observeAllTasks().collectLatest {

                _taskLists.value = it.map { it.toTask() }
                println("Hello988 $it")
            }
        }
    }

    fun addTask(title: String = "First", description: String = "Hello") {
        viewModelScope.launch {
            taskRepository.createTask(title, description)
        }
    }

    fun deleteTask(item: Task) {
        viewModelScope.launch {
            taskRepository.deleteTask(item.toLocal())
        }
    }

}