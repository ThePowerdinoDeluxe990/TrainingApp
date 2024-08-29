package com.powerdino.trainingapp.ui.screens.composables

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route:String,
    val selected:Boolean
)
