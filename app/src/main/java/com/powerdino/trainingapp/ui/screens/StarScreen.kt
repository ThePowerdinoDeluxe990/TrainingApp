package com.powerdino.trainingapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.powerdino.trainingapp.R

@Composable
fun StarScreen(
    modifier: Modifier
){
    Column (
        modifier = modifier,
    ){
        Text(stringResource(R.string.button_training_text))
    }
}