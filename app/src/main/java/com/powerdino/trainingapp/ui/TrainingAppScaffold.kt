package com.powerdino.trainingapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.screens.StarScreen
import com.powerdino.trainingapp.ui.screens.TrainingScreen
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme

@Composable
fun TrainingAppScaffold(){
    val navController = rememberNavController()

    var Selected by remember {
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
                    //TODO refactor this
                      if (Selected){
                          IconMenuButton(
                              onClick = { navController.navigate(AppScreens.TrainingScreen.route) },
                              description = R.string.home_button,
                              icon = Icons.Filled.Home,
                              iconName = stringResource(id = R.string.button_home_text)
                          )

                          IconMenuButton(
                              onClick = { navController.navigate(AppScreens.StarScreen.route)
                                        Selected = false},
                              description = R.string.my_training,
                              icon = Icons.Outlined.Email,
                              iconName = stringResource(id = R.string.button_training_text)
                          )
                      }else{
                          IconMenuButton(
                              onClick = { navController.navigate(AppScreens.TrainingScreen.route)
                                        Selected = true},
                              description = R.string.home_button,
                              icon = Icons.Outlined.Home,
                              iconName = stringResource(id = R.string.button_home_text)
                          )

                          IconMenuButton(
                              onClick = { navController.navigate(AppScreens.StarScreen.route) },
                              description = R.string.my_training,
                              icon = Icons.Filled.Email,
                              iconName = stringResource(id = R.string.button_training_text)
                          )
                      }
                  }
              }
          )

        }
    ){ innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = AppScreens.TrainingScreen.route,

                ){
                composable(
                    route = AppScreens.TrainingScreen.route
                ){
                    TrainingScreen()
                }

                composable(
                    route = AppScreens.StarScreen.route
                ){
                    StarScreen()
                }
            }
        }
    }
}

@Composable
fun IconMenuButton(
    onClick:() -> Unit,
    @StringRes description:Int,
    icon:ImageVector,
    iconName:String
){
    Column (
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        IconButton(onClick = onClick) {
            Icon(
                imageVector = icon,
                contentDescription = stringResource(id = description)
            )
        }

        Text(
            text = iconName,
            style = MaterialTheme.typography.bodySmall
        )
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