package com.example.todoapp.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.MainTaskRepository
import com.example.todoapp.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val taskRepository: TaskRepository) : ViewModel() {

}