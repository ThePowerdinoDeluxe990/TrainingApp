package com.powerdino.trainingapp.ui.screens.lists

import android.graphics.Color
import com.powerdino.trainingapp.R

object ListOfExercises {
    val firstList = listOf(
        ListOfExerciseData(
            id = 1,
            difficultyLevel = "Easy",
            nameOf = "Beginner arms routine",
            pictureExercise = R.drawable.pushups,
            borderColor = Color.GREEN,
            descriptionOfExercise = "Easy arms routine",
            repes = "10"
        ),
        ListOfExerciseData(
            id = 2,
            difficultyLevel = "Medium",
            nameOf = "Advanced arms routine",
            borderColor = Color.YELLOW,
            pictureExercise = R.drawable.pushups,
            descriptionOfExercise = "Advanced arms routine",
            repes = "20"
        ),
        ListOfExerciseData(
            id = 3,
            difficultyLevel = "Hard",
            nameOf = "Expert arms routine",
            borderColor = Color.RED,
            pictureExercise = R.drawable.pushups,
            descriptionOfExercise = "Hard arms routine",
            repes = "30"
        )
    )

    val secondList = listOf(
        ListOfExerciseData(
            id = 4,
            difficultyLevel = "Easy",
            nameOf = "Beginner legs routine",
            borderColor = Color.GREEN,
            pictureExercise = R.drawable.squats,
            descriptionOfExercise = "Easy legs routine",
            repes = "10"
        ),
        ListOfExerciseData(
            id = 5,
            difficultyLevel = "Medium",
            nameOf = "Advanced legs routine",
            borderColor = Color.YELLOW,
            pictureExercise = R.drawable.squats,
            descriptionOfExercise = "Medium legs routine",
            repes = "20"
        ),
        ListOfExerciseData(
            id = 6,
            difficultyLevel = "Hard",
            nameOf = "Expert legs routine",
            borderColor = Color.RED,
            pictureExercise = R.drawable.squats,
            descriptionOfExercise = "Hard legs routine",
            repes = "30"
        )
    )

    val thirdList = listOf(
        ListOfExerciseData(
            id = 7,
            difficultyLevel = "Easy",
            nameOf = "Beginner running routine",
            borderColor = Color.GREEN,
            pictureExercise = R.drawable.running,
            descriptionOfExercise = "Easy running routine",
            repes = "10:00"
        ),
        ListOfExerciseData(
            id = 8,
            difficultyLevel = "Medium",
            nameOf = "Advanced running routine",
            pictureExercise = R.drawable.running,
            borderColor = Color.YELLOW,
            descriptionOfExercise = "Medium running routine",
            repes = "20:00"
        ),
        ListOfExerciseData(
            id = 9,
            difficultyLevel = "Hard",
            nameOf = "Expert running routine",
            pictureExercise = R.drawable.running,
            borderColor = Color.RED,
            descriptionOfExercise = "Hard running routine",
            repes = "30:00"
        )
    )
}