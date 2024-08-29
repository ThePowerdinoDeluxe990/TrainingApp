package com.powerdino.trainingapp.ui

sealed class NavAppScreens(val route:String) {
    object TrainingScreen: NavAppScreens(route = "TrainingScreen")
    object StarScreen: NavAppScreens(route = "StarScreen")
    object ExercisesListScreen: NavAppScreens(route = "ExercisesListScreen")
}