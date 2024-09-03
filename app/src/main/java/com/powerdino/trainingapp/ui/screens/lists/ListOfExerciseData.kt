package com.powerdino.trainingapp.ui.screens.lists

import kotlinx.serialization.Serializable

@Serializable
data class ListOfExerciseData(
    val id:Int,
    val difficultyLevel:String,
    val nameOf:String,
    val borderColor:Int,
    val pictureExercise:Int,
    val descriptionOfExercise:String,
    val repes:String
)
