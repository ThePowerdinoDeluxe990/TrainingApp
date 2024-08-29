package com.powerdino.trainingapp

import android.app.Application
import com.powerdino.trainingapp.data.AppDatabase

class TrainingApplication:Application() {
    val database:AppDatabase by lazy { AppDatabase.getDatabase(this) }
}