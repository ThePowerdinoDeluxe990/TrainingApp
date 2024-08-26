package com.powerdino.trainingapp.ui.screens.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.powerdino.trainingapp.ui.screens.ListOfExerciseData
import com.powerdino.trainingapp.ui.screens.lists.ListOfExercises

class NavigationParamsViewModel : ViewModel(){
    var currentList by mutableStateOf(
        ListOfExercises.firstList
    )
    private set

    fun setNavStateList(
        newList:List<ListOfExerciseData>
    ){
      currentList = newList
    }

    fun returnCurrentList(): List<ListOfExerciseData> {
        return currentList
    }
}