package com.powerdino.trainingapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.powerdino.trainingapp.data.ExerciseEntity
import com.powerdino.trainingapp.ui.NavAppScreens
import com.powerdino.trainingapp.ui.screens.composables.TrainingMenuComposable
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseDbViewModel
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseViewModel
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisesListScreen(
    navController: NavHostController,
    exerciseViewModel: ExerciseViewModel,
    titleArgument:String,
    dataBaseViewModel: ExerciseDbViewModel?
) {
    val coroutineScope  = rememberCoroutineScope()
    Scaffold (
        topBar ={
            TopAppBar(
                title = {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                        onClick = {
                            navController.navigate(NavAppScreens.TrainingScreen.route)
                        }
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack"
                        )
                    }
                        Text(text = titleArgument)
                    }
                }
            )
        }
    ){ innerPadding ->
        LazyColumn (
            modifier = Modifier.padding(innerPadding)
        ){
            items(exerciseViewModel.currentList){ item ->
                TrainingMenuComposable(
                    trainingName = item.nameOf,
                    trainingDescription = item.descriptionOfExercise,
                    trainingDifficulty = item.difficultyLevel,
                    borderColor = Color(item.borderColor),
                    borderSize = 2.dp,
                    clickAction = {
                        navController.navigate(
                            route = NavAppScreens.ExerciseScreen.route+"/${item.nameOf}/${item.difficultyLevel}/${item.pictureExercise}/${item.repes}"
                        )
                    },
                    starAction = {
                        coroutineScope.launch{
                            dataBaseViewModel?.insertItem(
                                item = ExerciseEntity(
                                    difficultyLevel = item.difficultyLevel,
                                    nameOf = item.nameOf,
                                    descriptionOfExercise = item.descriptionOfExercise,
                                    pictureExercise = item.pictureExercise,
                                    borderColor = item.borderColor,
                                    id = item.id,
                                    repets = item.repes
                                )
                            )
                        }
                    },
                    enableOrDisableStar = true,
                    enableOrDisableDelete = false,
                    deleteAction = {}
                )
            }
        }
    }
}



@Preview(
    showBackground = true,
    name = "black tablet",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_tablet"
)
@Preview(
    device = "id:pixel_tablet", showBackground = true, backgroundColor = 0xFFFFFFFF,
)
@Preview(
    showBackground = true,
    name = "black phone",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_7"
)
@Preview(
    showBackground = true,
    device = "id:pixel_7"
)
@Composable
private fun Preview() {
    TrainingAppTheme {
        Surface {
            ExercisesListScreen(
                navController = rememberNavController(),
                exerciseViewModel = ExerciseViewModel(),
                titleArgument = "Example Title",
                dataBaseViewModel = null
            )
        }
    }
}