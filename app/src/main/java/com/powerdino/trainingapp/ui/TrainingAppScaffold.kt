package com.powerdino.trainingapp.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.screens.ExercisesListScreen
import com.powerdino.trainingapp.ui.screens.StarScreen
import com.powerdino.trainingapp.ui.screens.TrainingScreen
import com.powerdino.trainingapp.ui.screens.composables.IconMenuButton
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseViewModel
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme



@Composable
fun TrainingAppScaffold(
    NavViewModel: ExerciseViewModel = viewModel()
){
    val navController = rememberNavController()
    val context = LocalContext.current


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
                              onClick = { navController.navigate(NavAppScreens.TrainingScreen.route) },
                              description = R.string.selected_home_button,
                              icon = Icons.Filled.Home,
                              iconName = stringResource(id = R.string.button_home_text),
                              color = MaterialTheme.colorScheme.secondaryContainer,
                              fontWeight = FontWeight.Bold
                          )

                          IconMenuButton(
                              onClick = {
                                  navController.navigate(NavAppScreens.StarScreen.route)
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
                                  navController.navigate(NavAppScreens.TrainingScreen.route)
                                  bottomSelected = true
                                },
                              description = R.string.home_button,
                              icon = Icons.Outlined.Home,
                              iconName = stringResource(id = R.string.button_home_text),
                              color = MaterialTheme.colorScheme.surface,
                              fontWeight = FontWeight.Normal
                          )

                          IconMenuButton(
                              onClick = { navController.navigate(NavAppScreens.StarScreen.route) },
                              description = R.string.selected_my_training,
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
            startDestination = NavAppScreens.TrainingScreen.route,
        ){
            composable(route = NavAppScreens.TrainingScreen.route){
                TrainingScreen(
                    navController,
                    exerciseViewModel = NavViewModel,
                    modifier = Modifier.padding(innerPadding)
                )
                BackHandler(true){
                    val activity = (context as? Activity)
                    activity?.finish()
                }
            }

            composable(route = NavAppScreens.StarScreen.route){
                StarScreen(
                    modifier = Modifier
                        .testTag("StarScreen")
                        .padding(innerPadding)
                )
                BackHandler(true){
                    navController.navigate(NavAppScreens.TrainingScreen.route)
                    bottomSelected = true
                }
            }

            composable(route = NavAppScreens.ExercisesListScreen.route+ "/{Title}",
                arguments = listOf(
                    navArgument(name="Title"){
                        type = NavType.StringType
                    }
                )
            ){
                ExercisesListScreen(
                    navController,
                    exerciseViewModel = NavViewModel,
                    titleArgument = it.arguments?.getString("Title")!!
                )

                BackHandler (true){
                    navController.navigate(NavAppScreens.TrainingScreen.route)
                }
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