package com.powerdino.trainingapp.ui

import kotlinx.serialization.Serializable

@Serializable
object AppScreens {
    @Serializable
    object TrainingScreen

    @Serializable
    object StarScreen

    @Serializable
    data class ArgScreenOfTrainings(
        val titleOfScreen:String
    )
}