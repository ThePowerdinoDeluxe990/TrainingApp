package com.powerdino.trainingapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.powerdino.trainingapp.ui.screens.composables.TrainingMenuComposable
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme


@Composable
fun TrainingScreen(){
    Column {

        Text(
            text = "Trainings",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding( 6.dp ),
            fontWeight = FontWeight.Bold
        )
        TrainingMenuComposable(
            trainingName = "Example 1",
            trainingDescription = "Lorem Ipsum"
        )

        TrainingMenuComposable(
            trainingName = "Example 2",
            trainingDescription = "Lorem Ipsum"
        )

        TrainingMenuComposable(
            trainingName = "Example 3",
            trainingDescription = "Lorem Ipsum"
        )

    }
}



@Preview(showBackground = true, device = "id:pixel_tablet")
@Preview(showBackground = true, device = "id:pixel_7")
@Composable
private fun Preview() {
    TrainingAppTheme {
    }
}