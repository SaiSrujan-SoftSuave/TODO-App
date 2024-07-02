package com.example.todoapp.presentation.screens.home

import com.example.todoapp.data.Task


data class TaskState(
    var isLoading: Boolean = false,
    var tasks:  List<Task> = emptyList(),
    val error: String? = null
)

