package com.powerdino.trainingapp.ui

import android.app.Activity
import android.widget.Toast
import androidx.compose.material3.Icon
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.screens.ExercisesListScreen
import com.powerdino.trainingapp.ui.screens.ExercisesScreens
import com.powerdino.trainingapp.ui.screens.StarScreen
import com.powerdino.trainingapp.ui.screens.TrainingScreen
import com.powerdino.trainingapp.ui.screens.composables.BottomNavigationItem
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseDbViewModel
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseViewModel



@Composable
fun TrainingAppScaffold(
    navViewModel: ExerciseViewModel = viewModel(),
    dataBaseViewModel:ExerciseDbViewModel = viewModel(factory = ExerciseDbViewModel.factory),
    windowSizeClass: WindowWidthSizeClass
){
    val navController = rememberNavController()
    val context = LocalContext.current

    var bottomSelected by rememberSaveable {
        mutableIntStateOf(0)
    }

    val bottomAppBarItems = listOf(
        BottomNavigationItem(
            title = stringResource(id = R.string.button_home_text),
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = NavAppScreens.TrainingScreen.route,
            selected = true
        ),
        BottomNavigationItem(
            title = stringResource(id = R.string.my_training),
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star,
            route = NavAppScreens.StarScreen.route,
            selected = false
        )
    )

    Scaffold (
        bottomBar = {
              NavigationBar {
                  bottomAppBarItems.forEachIndexed{ index, item ->
                      NavigationBarItem(
                          selected = bottomSelected == index,
                          onClick = {
                              bottomSelected = index
                              navController.navigate(item.route)
                          },
                          label = {
                              Text(item.title)
                          },
                          alwaysShowLabel = true,
                          icon = {
                              Icon(
                                  imageVector = if (index ==  bottomSelected) {
                                      item.selectedIcon
                                  } else item.unselectedIcon,
                                          contentDescription = item.title
                              )
                          }
                      )
                  }

              }
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavAppScreens.TrainingScreen.route,
        ){
            composable(route = NavAppScreens.TrainingScreen.route){
                TrainingScreen(
                    navController,
                    exerciseViewModel = navViewModel,
                    modifier = Modifier.padding(innerPadding),
                    windowWidthSizeClass = windowSizeClass,
                    dataBaseViewModel = dataBaseViewModel
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
                        .padding(innerPadding),
                    dataBaseViewModel = dataBaseViewModel,
                    navController = navController
                )
                BackHandler(true){
                    navController.navigate(NavAppScreens.TrainingScreen.route)
                    bottomSelected = 0
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
                    exerciseViewModel = navViewModel,
                    titleArgument = it.arguments?.getString("Title")!!,
                    dataBaseViewModel = dataBaseViewModel,
                    modifier = Modifier.padding( bottom = innerPadding.calculateBottomPadding())
                )

                BackHandler (true){
                    navController.navigate(NavAppScreens.TrainingScreen.route)
                }
            }

            composable( route = NavAppScreens.ExerciseScreen.route + "/{Name}/{Difficulty}/{Image}/{Repes}",
                arguments = listOf(
                    navArgument(name="Name"){
                        type = NavType.StringType
                    },
                    navArgument(name="Difficulty"){
                        type = NavType.StringType
                    },
                    navArgument(name="Image"){
                        type = NavType.IntType
                    },
                    navArgument(name="Repes"){
                        type = NavType.StringType
                    }
                )
                ){
                ExercisesScreens(
                    nameArgument = it.arguments?.getString("Name")!!,
                    imageArgument = it.arguments?.getInt("Image")!!,
                    repes = it.arguments?.getString("Repes")!!,
                    iconButtonClick = {
                        Toast.makeText(
                            context,
                            "Done!",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate(NavAppScreens.TrainingScreen.route)
                        bottomSelected = 0
                    }
                )
                BackHandler(true){
                    navController.navigate(NavAppScreens.TrainingScreen.route)
                    bottomSelected = 0
                }
            }
        }
    }
}

