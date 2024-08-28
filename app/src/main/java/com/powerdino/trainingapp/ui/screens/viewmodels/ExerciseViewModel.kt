package com.powerdino.trainingapp.ui.screens.viewmodels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.datastore.dataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import com.powerdino.trainingapp.ui.screens.ListOfExerciseData
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