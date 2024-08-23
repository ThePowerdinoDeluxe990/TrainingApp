package com.powerdino.trainingapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.powerdino.trainingapp.ui.AppScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisesListScreen(navController: NavHostController) {
    Scaffold (
        topBar ={ TopAppBar(title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                onClick = {
                    navController.navigate(AppScreens.TrainingScreen)
                }
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    "ArrowBack"
                )
            }
                Text("WORK IN PROGRESS")

            }
        })}
    ){ innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
        ){
            Text("ExercisesListScreen")
        }
    }

}