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
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.screens.composables.TrainingMenuComposable


@Composable
fun TrainingScreen(){
    Column (
    ){

        Text(
            text = stringResource(id = R.string.my_training_title),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding( 6.dp ),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
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
            TrainingScreen()
        }
    }
}