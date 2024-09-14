package com.powerdino.trainingapp.ui.screens

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.NavAppScreens
import com.powerdino.trainingapp.ui.screens.composables.TrainingMenuComposable
import com.powerdino.trainingapp.ui.screens.lists.ListOfExercises
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseDbViewModel
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseViewModel


@Composable
fun TrainingScreen(
    navController: NavHostController,
    exerciseViewModel: ExerciseViewModel,
    modifier: Modifier,
    windowWidthSizeClass: WindowWidthSizeClass,
    dataBaseViewModel: ExerciseDbViewModel?
){

    var isScreenExpanded by rememberSaveable  {
        mutableStateOf(false)
    }

    var titleArgumentExpanded by rememberSaveable {
        mutableStateOf("Nothing")
    }

    var isSelected by rememberSaveable {
        mutableStateOf(false)
    }

    var screenSize by remember {
        mutableFloatStateOf(1f)
    }

    when(windowWidthSizeClass){
        WindowWidthSizeClass.Expanded ->{
            isScreenExpanded = true
            screenSize = 0.5f
        }
        else -> {isScreenExpanded = false}
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = modifier.fillMaxWidth(screenSize)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = stringResource(id = R.string.my_training_title),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(6.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            TrainingMenuComposable(
                trainingName = "Arms",
                trainingDescription = stringResource(id = R.string.arm_description_routine),
                borderColor = MaterialTheme.colorScheme.primaryContainer,
                borderSize = 0.dp,
                trainingDifficulty = null,
                clickAction = {
                    Log.e("Info", isScreenExpanded.toString())
                    exerciseViewModel.setNavStateList(ListOfExercises.firstList)
                    if (isScreenExpanded) {
                        isSelected = true
                        titleArgumentExpanded = "Arms Training"
                    } else {
                        navController.navigate(
                            NavAppScreens.ExercisesListScreen.route + "/Arms Training"
                        )
                    }
                },
                starAction = {},
                enableOrDisableStar = false,
                enableOrDisableDelete = false,
                deleteAction = {}
            )

            TrainingMenuComposable(
                trainingName = "Legs",
                trainingDescription = stringResource(id = R.string.legs_description_routine),
                borderColor = MaterialTheme.colorScheme.primaryContainer,
                borderSize = 0.dp,
                trainingDifficulty = null,
                starAction = {},
                clickAction = {
                    exerciseViewModel.setNavStateList(ListOfExercises.secondList)
                    if (isScreenExpanded) {
                        isSelected = true
                        titleArgumentExpanded = "Legs Training"
                    } else {
                        navController.navigate(
                            NavAppScreens.ExercisesListScreen.route + "/Legs Training"
                        )
                    }

                },
                enableOrDisableStar = false,
                enableOrDisableDelete = false,
                deleteAction = {}
            )

            TrainingMenuComposable(
                trainingName = "Running",
                trainingDescription = stringResource(id = R.string.running_description_routine),
                borderColor = MaterialTheme.colorScheme.primaryContainer,
                borderSize = 0.dp,
                trainingDifficulty = null,
                starAction = {},
                clickAction = {
                    exerciseViewModel.setNavStateList(ListOfExercises.thirdList)
                    if (isScreenExpanded) {
                        isSelected = true
                        titleArgumentExpanded = "Running Training"
                    } else {
                        navController.navigate(
                            NavAppScreens.ExercisesListScreen.route + "/Running Training"
                        )
                    }

                },
                enableOrDisableStar = false,
                enableOrDisableDelete = false,
                deleteAction = {}
            )
        }

        if(isSelected){
            ExercisesListScreen(
                navController = navController,
                exerciseViewModel = exerciseViewModel,
                titleArgument = titleArgumentExpanded,
                dataBaseViewModel = dataBaseViewModel,
                modifier = modifier
            )
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
            TrainingScreen(
                rememberNavController(),
                modifier = Modifier,
                exerciseViewModel = ExerciseViewModel(),
                windowWidthSizeClass = WindowWidthSizeClass.Expanded,
                dataBaseViewModel = null
            )
        }
    }
}