package com.example.todoapp.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.presentation.screens.BottomNavigation
import com.example.todoapp.presentation.screens.HomeScreen
import com.example.todoapp.presentation.screens.ToDoAppBar
import com.example.todoapp.presentation.screens.addtask.AddTaskScreen
import com.example.todoapp.presentation.screens.completed.CompletedScreen

@Composable
fun TodoNavHost() {
    val navController = rememberNavController()
    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute  = currentDestination?.destination?.route ?: Screens.HOME_SCREEN

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        ToDoAppBar(Modifier, navController )
    }, bottomBar = {
        BottomNavigation(navController = navController,
            onHomeClick = {

            }, onCompletedClick = {
                navController.navigate(Screens.COMPLETED_SCREEN)
            },
        )
    }, floatingActionButton = {
        AnimatedVisibility(currentRoute == Screens.HOME_SCREEN){
            FloatingActionButton(onClick = { navController.navigate(Screens.ADDTASK_SCREEN) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    }, contentWindowInsets = WindowInsets.safeContent
        ) { innerPadding ->
        NavHost(navController = navController, startDestination = Screens.HOME_SCREEN,

            ) {
            composable(Screens.HOME_SCREEN) {
                println("cheko89 ${navController.currentDestination?.route}")
                HomeScreen(modifier = Modifier.padding(innerPadding), navController)
            }
            composable(Screens.COMPLETED_SCREEN) {
                CompletedScreen(modifier = Modifier)
            }
            composable(Screens.ADDTASK_SCREEN) {
                AddTaskScreen(modifier = Modifier)
            }

        }
    }

}

object Screens {

    const val ADDTASK_SCREEN="Add Task"
    const val COMPLETED_SCREEN = "Completed Task"
    const val HOME_SCREEN = "TODO App"
}