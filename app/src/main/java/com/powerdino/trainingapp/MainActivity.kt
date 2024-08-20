package com.powerdino.trainingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.powerdino.trainingapp.ui.TrainingAppScaffold
import com.powerdino.trainingapp.ui.theme.TrainingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrainingAppTheme {
                TrainingAppScaffold()
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
private fun Preview() {
    TrainingAppTheme {
        TrainingAppScaffold()
    }
}