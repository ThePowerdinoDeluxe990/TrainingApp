package com.powerdino.trainingapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.screens.ExercisesListScreen
import com.powerdino.trainingapp.ui.screens.StarScreen
import com.powerdino.trainingapp.ui.screens.TrainingScreen
import com.powerdino.trainingapp.ui.screens.composables.IconMenuButton
import com.powerdino.trainingapp.ui.screens.viewmodels.NavigationParamsViewModel
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme
@Composable
fun TrainingAppScaffold(
    NavViewModel: NavigationParamsViewModel = viewModel()
){
    val navController = rememberNavController()

    var bottomSelected by remember {
        mutableStateOf(true)
    }

    Scaffold (
        bottomBar = {
          BottomAppBar(
              actions = {
                  Row(
                      horizontalArrangement = Arrangement.SpaceEvenly,
                      modifier = Modifier.fillMaxWidth()
                  ) {
                      //Logic of bottom bar
                      if (bottomSelected){
                          IconMenuButton(
                              onClick = { navController.navigate(AppScreens.TrainingScreen) },
                              description = R.string.home_button,
                              icon = Icons.Filled.Home,
                              iconName = stringResource(id = R.string.button_home_text),
                              color = MaterialTheme.colorScheme.secondaryContainer,
                              fontWeight = FontWeight.Bold
                          )

                          IconMenuButton(
                              onClick = {
                                  navController.navigate(AppScreens.StarScreen)
                                  bottomSelected = false
                                },
                              description = R.string.my_training,
                              icon = Icons.Outlined.Email,
                              iconName = stringResource(id = R.string.button_training_text),
                              color = MaterialTheme.colorScheme.surface,
                              fontWeight = FontWeight.Normal
                          )
                      }else{
                          IconMenuButton(
                              onClick = {
                                  navController.navigate(AppScreens.TrainingScreen)
                                  bottomSelected = true
                                },
                              description = R.string.home_button,
                              icon = Icons.Outlined.Home,
                              iconName = stringResource(id = R.string.button_home_text),
                              color = MaterialTheme.colorScheme.surface,
                              fontWeight = FontWeight.Normal
                          )

                          IconMenuButton(
                              onClick = { navController.navigate(AppScreens.StarScreen) },
                              description = R.string.my_training,
                              icon = Icons.Filled.Email,
                              iconName = stringResource(id = R.string.button_training_text),
                              color = MaterialTheme.colorScheme.secondaryContainer,
                              fontWeight = FontWeight.Bold
                          )
                      }
                  }
              }
          )
        }
    ){ innerPadding ->

            NavHost(
                navController = navController,
                startDestination = AppScreens.TrainingScreen,
            ){
                composable<AppScreens.TrainingScreen>{
                    TrainingScreen(
                        navController,
                        navigationParamsViewModel = NavViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                composable<AppScreens.StarScreen>{
                    StarScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                composable<AppScreens.ArgScreenOfTrainings>{
                    ExercisesListScreen(
                        navController,
                        navigationParamsViewModel = NavViewModel
                    )
                }
            }
    }
}


@Preview(showBackground = true, device = "id:pixel_tablet")
@Preview(showBackground = true, device = "id:pixel_7")
@Composable
private fun Preview() {
    TrainingAppTheme {
        TrainingAppScaffold()
    }
}