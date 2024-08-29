package com.powerdino.trainingapp.ui.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.powerdino.trainingapp.TrainingApplication
import com.powerdino.trainingapp.data.ExerciseDao
import com.powerdino.trainingapp.data.ExerciseEntity
import com.powerdino.trainingapp.ui.screens.ListOfExerciseData
import kotlinx.coroutines.flow.Flow

class ExerciseDbViewModel(
    private val exerciseDao: ExerciseDao
):ViewModel(){

    fun getAll(): Flow<List<ExerciseEntity>> = exerciseDao.getAll()

    suspend fun insertItem(
        item:ExerciseEntity
    ) = exerciseDao.insert(item)

    suspend fun deleteItem(
        item:ExerciseEntity
    ) = exerciseDao.delete(item)

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TrainingApplication)
                ExerciseDbViewModel(
                    application.database.execiseDao()
                )
            }
        }
    }
}