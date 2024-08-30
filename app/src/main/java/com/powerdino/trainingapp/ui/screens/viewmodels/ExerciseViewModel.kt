package com.powerdino.trainingapp.ui.screens.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.powerdino.trainingapp.ui.screens.lists.ListOfExerciseData
import com.powerdino.trainingapp.ui.screens.lists.ListOfExercises

class ExerciseViewModel : ViewModel(){
    var currentList by mutableStateOf(
        ListOfExercises.firstList
    )
    private set

    fun setNavStateList(
        newList:List<ListOfExerciseData>
    ){
      currentList = newList
    }
}