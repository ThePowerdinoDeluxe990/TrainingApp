package com.powerdino.trainingapp.ui.screens.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.powerdino.trainingapp.R
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme

@Composable
fun DBEmptyComposable(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Icon(
            imageVector = Icons.Rounded.Warning,
            contentDescription = stringResource(id = R.string.warning_icon_description),
            modifier = Modifier.size(150.dp),
            tint = MaterialTheme.colorScheme.error
        )

        Text(
            text = stringResource(id = R.string.is_empty_text),
            textAlign = TextAlign.Unspecified,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(id = R.string.is_empty_description),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(5.dp)
        )
    }
}


@Preview(showBackground = true, device = "id:pixel_tablet", showSystemUi = true)
@Preview(showBackground = true, device = "id:pixel_7", showSystemUi = true)
@Composable
private fun Preview() {
    TrainingAppTheme {
        DBEmptyComposable()
    }
}