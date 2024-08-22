package com.powerdino.trainingapp.ui.screens

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class ListOfExerciseData(
    val difficultyLevel:String,
    val nameOf:String,
    val pictureExercise:Int,
    val descriptionOfExercise:String
)
