package com.example.todoapp.presentation.screens.completed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CompletedScreen(modifier: Modifier) {
    val windowInfo = LocalConfiguration.current
    Column(modifier = modifier.padding(top = windowInfo.screenHeightDp.dp/8)) {
    Text(text = "Completed Screen")
    }
}

