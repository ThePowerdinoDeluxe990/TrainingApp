package com.powerdino.trainingapp.ui.screens

import kotlinx.serialization.Serializable

@Serializable
data class ListOfExerciseData(
    val difficultyLevel:String,
    val nameOf:String,
    val borderColor:Int,
    val pictureExercise:Int,
    val descriptionOfExercise:String
)
