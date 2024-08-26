package com.powerdino.trainingapp.ui.screens.lists

import android.graphics.Color
import androidx.compose.material3.MaterialTheme
import com.powerdino.trainingapp.ui.screens.ListOfExerciseData

object ListOfExercises {
    val firstList = listOf(
        ListOfExerciseData(
            difficultyLevel = "Easy",
            nameOf = "Example Exercise",
            pictureExercise = 12,
            borderColor = Color.GREEN,
            descriptionOfExercise = "Lorem Ipsum"
        ),
        ListOfExerciseData(
            difficultyLevel = "Medium",
            nameOf = "Example Exercise",
            borderColor = Color.YELLOW,
            pictureExercise = 12,
            descriptionOfExercise = "Lorem Ipsum"
        ),
        ListOfExerciseData(
            difficultyLevel = "Hard",
            nameOf = "Example Exercise",
            borderColor = Color.RED,
            pictureExercise = 12,
            descriptionOfExercise = "Lorem Ipsum"
        )
    )

    val secondList = listOf(
        ListOfExerciseData(
            difficultyLevel = "Easy",
            nameOf = "Example Exercise 2",
            borderColor = Color.GREEN,
            pictureExercise = 12,
            descriptionOfExercise = "Lorem Ipsum"
        ),
        ListOfExerciseData(
            difficultyLevel = "Medium",
            nameOf = "Example Exercise 2",
            borderColor = Color.YELLOW,
            pictureExercise = 12,
            descriptionOfExercise = "Lorem Ipsum"
        ),
        ListOfExerciseData(
            difficultyLevel = "Hard",
            nameOf = "Example Exercise 2",
            borderColor = Color.RED,
            pictureExercise = 12,
            descriptionOfExercise = "Lorem Ipsum"
        )
    )

    val thirdList = listOf(
        ListOfExerciseData(
            difficultyLevel = "Easy",
            nameOf = "Example Exercise 3",
            borderColor = Color.GREEN,
            pictureExercise = 12,
            descriptionOfExercise = "Lorem Ipsum"
        ),
        ListOfExerciseData(
            difficultyLevel = "Medium",
            nameOf = "Example Exercise 3",
            pictureExercise = 12,
            borderColor = Color.YELLOW,
            descriptionOfExercise = "Lorem Ipsum"
        ),
        ListOfExerciseData(
            difficultyLevel = "Hard",
            nameOf = "Example Exercise 3",
            pictureExercise = 12,
            borderColor = Color.RED,
            descriptionOfExercise = "Lorem Ipsum"
        )
    )
}