package com.powerdino.trainingapp

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.powerdino.trainingapp.ui.TrainingAppScaffold
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testBottomBar(){
        composeTestRule.setContent {
            TrainingAppScaffold(
                windowSizeClass = WindowWidthSizeClass.Medium
            )
        }

        composeTestRule.onNodeWithText("My trainings").performClick()
        composeTestRule.onNodeWithText("My trainings").assertExists()
    }

    @Test
    fun testBottomBarIcons(){
        composeTestRule.setContent {
            TrainingAppScaffold(
                windowSizeClass = WindowWidthSizeClass.Medium
            )
        }

        composeTestRule.onNodeWithText("My trainings").performClick()
        composeTestRule.onNodeWithContentDescription(
            label ="Selected My trainings",
            //Esta opcion es cristo, te quiero mucho useUnmergedTree = true
            useUnmergedTree = true
        )
    }
}