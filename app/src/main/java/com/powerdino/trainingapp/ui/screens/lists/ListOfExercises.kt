package com.powerdino.trainingapp.ui.screens.lists

import android.graphics.Color

object ListOfExercises {
    val firstList = listOf(
        ListOfExerciseData(
            id = 1,
            difficultyLevel = "Easy",
            nameOf = "Beginner arms routine",
            pictureExercise = 12,
            borderColor = Color.GREEN,
            descriptionOfExercise = "Easy arms routine"
        ),
        ListOfExerciseData(
            id = 2,
            difficultyLevel = "Medium",
            nameOf = "Advanced arms routine",
            borderColor = Color.YELLOW,
            pictureExercise = 12,
            descriptionOfExercise = "Advanced arms routine"
        ),
        ListOfExerciseData(
            id = 3,
            difficultyLevel = "Hard",
            nameOf = "Expert arms routine",
            borderColor = Color.RED,
            pictureExercise = 12,
            descriptionOfExercise = "Hard arms routine"
        )
    )

    val secondList = listOf(
        ListOfExerciseData(
            id = 4,
            difficultyLevel = "Easy",
            nameOf = "Beginner legs routine",
            borderColor = Color.GREEN,
            pictureExercise = 12,
            descriptionOfExercise = "Easy legs routine"
        ),
        ListOfExerciseData(
            id = 5,
            difficultyLevel = "Medium",
            nameOf = "Advanced legs routine",
            borderColor = Color.YELLOW,
            pictureExercise = 12,
            descriptionOfExercise = "Medium legs routine"
        ),
        ListOfExerciseData(
            id = 6,
            difficultyLevel = "Hard",
            nameOf = "Expert legs routine",
            borderColor = Color.RED,
            pictureExercise = 12,
            descriptionOfExercise = "Hard legs routine"
        )
    )

    val thirdList = listOf(
        ListOfExerciseData(
            id = 7,
            difficultyLevel = "Easy",
            nameOf = "Beginner running routine",
            borderColor = Color.GREEN,
            pictureExercise = 12,
            descriptionOfExercise = "Easy running routine"
        ),
        ListOfExerciseData(
            id = 8,
            difficultyLevel = "Medium",
            nameOf = "Advanced running routine",
            pictureExercise = 12,
            borderColor = Color.YELLOW,
            descriptionOfExercise = "Medium running routine"
        ),
        ListOfExerciseData(
            id = 9,
            difficultyLevel = "Hard",
            nameOf = "Expert running routine",
            pictureExercise = 12,
            borderColor = Color.RED,
            descriptionOfExercise = "Hard running routine"
        )
    )
}