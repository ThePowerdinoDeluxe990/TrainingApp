package com.powerdino.trainingapp.ui.screens.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme

@Composable
fun TrainingMenuComposable(
    trainingName:String,
    trainingDescription:String
){
    Card (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Column (
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                text = trainingName,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 6.dp)
            )

            Text(
                text = trainingDescription,
                style = MaterialTheme.typography.bodyLarge
            )

        }
    }
}

@Preview(showBackground = true, device = "id:pixel_tablet")
@Preview(showBackground = true, device = "id:pixel_7")
@Composable
private fun Preview() {
    TrainingAppTheme {
        TrainingMenuComposable(
            "Example",
            "Lorem Ipsum"
        )
    }
}