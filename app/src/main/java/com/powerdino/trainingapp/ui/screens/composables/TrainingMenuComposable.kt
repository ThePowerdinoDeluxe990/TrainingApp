package com.powerdino.trainingapp.ui.screens.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme

@Composable
fun TrainingMenuComposable(
    trainingName:String,
    trainingDescription:String,
    trainingDifficulty:String?,
    borderColor: Color,
    borderSize:Dp,
    clickAction:() -> Unit,
    starAction:() -> Unit,
    deleteAction:() -> Unit,
    enableOrDisableStar:Boolean,
    enableOrDisableDelete:Boolean
){
    Card (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        border = BorderStroke(
            borderSize,
            borderColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        onClick = clickAction
    ){
        Column (
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                text = trainingName,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding( 6.dp)
            )

            trainingDifficulty?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding( 6.dp)
                )
            }

            Text(
                text = trainingDescription,
                style = MaterialTheme.typography.bodyLarge ,
                modifier = Modifier.padding( 6.dp)
            )

            if(enableOrDisableStar){
                Button(
                    onClick = starAction,
                    modifier = Modifier.padding(5.dp)
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = stringResource(id = R.string.add_to_star),
                            tint = Color.Yellow,
                        )

                        Spacer( modifier = Modifier.padding(2.dp))

                        Text("Star")
                    }
                }
            }

            if(enableOrDisableDelete){
                Button(
                    onClick = deleteAction,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = stringResource(id = R.string.add_to_star),
                        )

                        Spacer( modifier = Modifier.padding(2.dp))

                        Text("Delete")
                    }
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
        Column {
            TrainingMenuComposable(
                "Example",
                "Lorem Ipsum",
                "Easy",
                MaterialTheme.colorScheme.surface,
                0.dp,
                {},
                {},
                {},
                true,
                false
            )
            TrainingMenuComposable(
                "Example",
                "Lorem Ipsum",
                "Easy",
                MaterialTheme.colorScheme.surface,
                0.dp,
                {},
                {},
                {},
                false,
                false
            )
            TrainingMenuComposable(
                    "Example",
            "Lorem Ipsum",
            "Easy",
            MaterialTheme.colorScheme.surface,
            0.dp,
            {},
            {},
                {},
            false,
            true
            )
        }

    }
}