package com.powerdino.trainingapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.NavAppScreens
import com.powerdino.trainingapp.ui.screens.composables.TrainingMenuComposable
import com.powerdino.trainingapp.ui.screens.lists.ListOfExercises
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseViewModel


@Composable
fun TrainingScreen(
    navController: NavController,
    exerciseViewModel: ExerciseViewModel,
    modifier: Modifier
){
    Column(
        modifier = modifier
    ){
        Text(
            text = stringResource(id = R.string.my_training_title),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding( 6.dp ),
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
                exerciseViewModel.setNavStateList(ListOfExercises.firstList)
                navController.navigate(
                    NavAppScreens.ExercisesListScreen.route + "/Arms Training"
                )
            },
            starAction = {},
            enableOrDisableStar = false
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
                navController.navigate(
                    NavAppScreens.ExercisesListScreen.route + "/Legs Training"
                )
            },
            enableOrDisableStar = false
        )

        TrainingMenuComposable(
            trainingName = "Running",
            trainingDescription = stringResource(id = R.string.running_description_routine) ,
            borderColor = MaterialTheme.colorScheme.primaryContainer,
            borderSize = 0.dp,
            trainingDifficulty = null,
            starAction = {},
            clickAction = {
                exerciseViewModel.setNavStateList(ListOfExercises.thirdList)
                navController.navigate(
                    NavAppScreens.ExercisesListScreen.route + "/Running Training"
                )
            },
            enableOrDisableStar = false
        )
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
                exerciseViewModel = ExerciseViewModel()
            )
        }
    }
}