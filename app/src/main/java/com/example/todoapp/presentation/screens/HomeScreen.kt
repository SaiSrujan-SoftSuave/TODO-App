package com.example.todoapp.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.R
import com.example.todoapp.presentation.Screens

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = Modifier) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoAppBar(modifier: Modifier = Modifier, navController: NavController) {

    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route ?: Screens.HOME_SCREEN

    TopAppBar(title = {
        Text(
            text = currentRoute, fontWeight = FontWeight.Bold
        )
    }, modifier = modifier, actions = {
        if (currentRoute == Screens.HOME_SCREEN) Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "calendar"
        )
    }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = Color.White,
        actionIconContentColor = Color.White
    ),
        navigationIcon = {
            if (currentRoute != Screens.HOME_SCREEN) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "list",
                        tint = Color.White
                    )
                }
            }

        }
    )
}

@Composable
fun ToDoCardItem(
    modifier: Modifier = Modifier,
    title: String = "title world",
    description: String = "description world",
    onEditClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    onCheckClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(84.dp)
            .clip(RoundedCornerShape(15.dp))
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(start = 10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Row {
                IconButton(onClick = { onEditClick() }) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Edit",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = { onDeleteClick() }) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "calendar",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = { onCheckClick() }) {
                    Icon(
                        imageVector = Icons.Outlined.CheckCircle,
                        contentDescription = "calendar",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }

}

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    onHomeClick: () -> Unit = {},
    onCompletedClick: () -> Unit = {},
) {
    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route ?: Screens.HOME_SCREEN

    AnimatedVisibility(
        visible = currentRoute == Screens.HOME_SCREEN,
        enter = slideInVertically{
            it
        },
        exit = slideOutVertically{
            it/2
        }
    ) {
        NavigationBar(modifier = modifier.fillMaxWidth()) {
            NavigationBarItem(
                selected = currentRoute == Screens.HOME_SCREEN,
                onClick = { onHomeClick() },
                icon = { Icon(imageVector = Icons.Default.List, contentDescription = "list") })
            NavigationBarItem(
                selected = currentRoute == Screens.COMPLETED_SCREEN,
                onClick = { onCompletedClick() },
                icon = {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "list"
                    )
                })
        }
    }
}

@Composable
@Preview
fun BottomNavigationPreview() {
//    BottomNavigation()
}

@Composable
@Preview(showBackground = true)
fun ToDoCardItemPreview() {
    ToDoCardItem()
}

@Composable
@Preview
fun ToDoAppBarPreview() {
//    ToDoAppBar(navController = rememberNavController())
}