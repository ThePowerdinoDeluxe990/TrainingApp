package com.powerdino.trainingapp.ui

sealed class AppScreens(val route:String){
    object TrainingScreen:AppScreens("TrainingScreen")
    object StarScreen:AppScreens("StarScreen")
}