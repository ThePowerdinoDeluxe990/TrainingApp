package com.powerdino.trainingapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.powerdino.trainingapp.ui.screens.composables.TrainingMenuComposable
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseDbViewModel

@Composable
fun StarScreen(
    modifier: Modifier,
    dataBaseViewModel: ExerciseDbViewModel
){
    val showAllItems by dataBaseViewModel.getAll().collectAsState(emptyList())

    LazyColumn (
        modifier = modifier,
    ){
        items(showAllItems){ item ->
            TrainingMenuComposable(
                trainingName = item.nameOf,
                trainingDescription = item.descriptionOfExercise,
                trainingDifficulty = item.difficultyLevel,
                borderColor = Color(item.borderColor),
                borderSize = 2.dp,
                clickAction = {},
                starAction = {},
                enableOrDisableStar = false
            )
        }

    }
}