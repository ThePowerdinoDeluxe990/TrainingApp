package com.powerdino.trainingapp.ui

import android.app.Activity
import androidx.compose.material3.Icon
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.powerdino.trainingapp.ui.screens.composables.BottomNavigationItem
import com.powerdino.trainingapp.ui.screens.composables.IconMenuButton
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseViewModel
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainingAppScaffold(
    NavViewModel: ExerciseViewModel = viewModel()
){
    val navController = rememberNavController()
    val context = LocalContext.current


    var bottomSelected by rememberSaveable {
        mutableStateOf(0)
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