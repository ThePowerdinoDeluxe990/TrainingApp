package com.powerdino.trainingapp.ui

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

// TODO Finish this
class storeCurrentExercise(
    private val context: Context
){

    companion object {
        private val Context.dataStore: DataStore<Preferences>
            by preferencesDataStore("CurrentExercise")
    }

    suspend fun saveCurrentExercise(
        difficultyLevel:String,
        nameOf:String,
        borderColor:Int,
        pictureExercise:Int,
        descriptionOfExercise:String
    ){
        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey("difficultyLevel")] = difficultyLevel
            preferences[stringPreferencesKey("nameOf")] = nameOf
            preferences[stringPreferencesKey("borderColor")] = borderColor.toString()
            preferences[stringPreferencesKey("pictureExercise")] = pictureExercise.toString()
            preferences[stringPreferencesKey("descriptionOfExercise")] = descriptionOfExercise
        }
    }
}