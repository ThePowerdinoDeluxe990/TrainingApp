package com.powerdino.trainingapp.data

import androidx.annotation.NonNull
import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_exercise")
data class ExerciseEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @ColumnInfo(name="difficulty_level")
    val difficultyLevel:String,

    @ColumnInfo(name="name_of")
    val nameOf:String,

    @ColumnInfo(name="border_color")
    val borderColor: Int,

    @ColumnInfo(name = "picture_exercise")
    val pictureExercise:Int,

    @ColumnInfo(name = "description_of_exercise")
    val descriptionOfExercise:String
)