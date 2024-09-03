package com.powerdino.trainingapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.powerdino.trainingapp.ui.NavAppScreens
import com.powerdino.trainingapp.ui.screens.composables.DBEmptyComposable
import com.powerdino.trainingapp.ui.screens.composables.TrainingMenuComposable
import com.powerdino.trainingapp.ui.screens.viewmodels.ExerciseDbViewModel
import kotlinx.coroutines.launch

@Composable
fun StarScreen(
    modifier: Modifier,
    dataBaseViewModel: ExerciseDbViewModel,
    navController: NavController
){
    val showAllItems by dataBaseViewModel.getAll().collectAsState(emptyList())
    val coroutineScope  = rememberCoroutineScope()


    if(showAllItems.isEmpty()){
        Column (
            modifier = modifier
        ){
            Text(
                text = "My Trainings",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding( 6.dp ),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            DBEmptyComposable()
        }
    }else{
        Column (
            modifier = modifier
        ){
            Text(
                text = "My Trainings",
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(6.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            LazyColumn{
                items(showAllItems) { item ->
                    TrainingMenuComposable(
                        trainingName = item.nameOf,
                        trainingDescription = item.descriptionOfExercise,
                        trainingDifficulty = item.difficultyLevel,
                        borderColor = Color(item.borderColor),
                        borderSize = 2.dp,
                        clickAction = {
                           navController.navigate(
                               route = NavAppScreens.ExerciseScreen.route+"/${item.nameOf}/${item.difficultyLevel}/${item.pictureExercise}/${item.repets}"
                           )
                        },
                        starAction = {},
                        enableOrDisableStar = false,
                        enableOrDisableDelete = true,
                        deleteAction = {
                            coroutineScope.launch {
                                dataBaseViewModel.deleteItem(item = item)
                            }
                        }
                    )
                }
            }
        }
    }
}