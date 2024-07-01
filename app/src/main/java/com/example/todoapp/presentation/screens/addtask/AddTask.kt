package com.example.todoapp.presentation.screens.addtask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@Composable
fun AddTaskScreen(modifier: Modifier) {
    val windowInfo = LocalConfiguration.current
    Column(modifier = modifier.fillMaxSize().padding(top = windowInfo.screenHeightDp.dp/8),) {
        var title by remember {
            mutableStateOf("")
        }
        var description by remember {
            mutableStateOf("")
        }
        TextField(value = title, onValueChange = { title = it }, placeholder = {
            Text(
                text = stringResource(
                    R.string.title
                )
            )
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(  10.dp))
        TextField(value = description, onValueChange = { description = it }, placeholder = {
            Text(text = stringResource(R.string.description))
        }, modifier = Modifier
            .fillMaxWidth()
            .padding( 10.dp))
        Button(
            onClick = {   },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(10.dp)
        ) {
            Text(text = stringResource(R.string.add))
        }
    }
}