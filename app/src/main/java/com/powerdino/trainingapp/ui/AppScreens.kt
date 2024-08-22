package com.powerdino.trainingapp.ui

import com.powerdino.trainingapp.ui.screens.ListOfExerciseData
import kotlinx.serialization.Serializable

object AppScreens {
    @Serializable
    object TrainingScreen

    @Serializable
    object StarScreen

    @Serializable
    data class ArgScreenOfTrainings(
        val exerciseList:MutableList<ListOfExerciseData>
    )
}